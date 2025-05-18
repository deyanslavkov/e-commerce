package com.shop.myshop.service;

import com.shop.myshop.model.UserEntity;
import com.shop.myshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true)
public class UserServiceImpl implements UserService {
  
  private UserRepository userRepository;
  
  @Override
  public UserEntity findByUsername(String username) {
    // return userRepository.findByUsername(username);
    return UserEntity.builder()
        .id(1l)
        .username(username)
        .build();
  }
}