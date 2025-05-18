package com.shop.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
  
  @GetMapping("/template")
  public String homePage(Model model) {
    model.addAttribute("msg", "Hello from Spring Boot with Thymeleaf!");
    return "greeting";
  }
  
}