package com.shop.myshop;

import com.shop.myshop.model.UserEntity;
import com.shop.myshop.repository.UserRepository;
import com.shop.myshop.service.UserService;
import com.shop.myshop.service.UserServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void test() {
        when(userRepository.findByUsername(eq("admin")))
                .thenReturn(Optional.of(UserEntity.builder().username("admin2").build()));

        UserEntity admin = userService.findByUsername("admin");

        assertThat(admin).usingRecursiveComparison()
                .isEqualTo(UserEntity.builder().username("admin2").build());
    }

    @Test
    public void test2() {
        when(userRepository.findByUsername(eq("admin")))
                .thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> userService.findByUsername("admin"));
    }
}
