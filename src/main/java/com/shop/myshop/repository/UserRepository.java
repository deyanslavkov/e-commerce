package com.shop.myshop.repository;

import com.shop.myshop.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  
  // select * from user where username = 'pesho'
  UserEntity findByUsername(String username);
  
  UserEntity findUserByCreatedAtBefore(Instant createdAtBefore);
  
  @Query(value = "select * from user", nativeQuery = true)
  List<UserEntity> getUserNative();
  
  @Query(value = "select * from user where username = :username", nativeQuery = true)
  List<UserEntity> getUserNativeByUsername(@Param("username") String username);
  
  @Query(value = "select u from UserEntity u where u.username = :username")
  List<UserEntity> getUser(@Param("username") String username);
}