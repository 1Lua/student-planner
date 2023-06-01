package com.example.planner.controllers;

import com.example.planner.dto.CreateUserDto;
import com.example.planner.dto.CreatedUserDto;
import com.example.planner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/registration")
@RequiredArgsConstructor
public class RegistrationController {
  private final UserService userService;

  @PostMapping("/signin")
  public ResponseEntity<CreatedUserDto> addNewUser(@RequestBody CreateUserDto createUserDto) {
    return ResponseEntity.ok(userService.createNewUser(createUserDto));
  }
}
