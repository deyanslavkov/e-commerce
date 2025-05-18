package com.shop.myshop.service;

import com.shop.myshop.model.UserEntity;

public interface UserService {
  
  UserEntity findByUsername(String username);
}