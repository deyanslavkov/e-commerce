package com.shop.myshop.service;

import com.shop.myshop.model.UserEntity;
import com.shop.myshop.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true)
public class UserServiceImpl implements UserService {
  
  private final UserRepository userRepository;
  
  @Override
  public UserEntity findByUsername(String username) {
    return userRepository.findByUsername("admin")
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
  }

  public void save() {
    UserEntity admin = UserEntity.builder()
            .username("admin")
            .build();
    userRepository.save(admin);
  }
}