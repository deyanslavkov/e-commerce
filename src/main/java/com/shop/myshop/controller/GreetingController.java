package com.shop.myshop.controller;

import com.shop.myshop.model.UserEntity;
import com.shop.myshop.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class GreetingController {

  @Value("${properties.message}")
  private String message;

  private final UserRepository userRepository;

  @GetMapping("/template")
  public String homePage(Model model) {
    model.addAttribute("msg", message);
    return "greeting";
  }
}