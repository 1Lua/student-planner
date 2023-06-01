package com.example.planner.utils;

import com.example.planner.dto.CreatedUserDto;
import com.example.planner.entities.User;

public class UserConverter {
  public static CreatedUserDto fromUserToCreated(User user) {
    return CreatedUserDto.builder()
        .id(user.getId())
        .username(user.getUsername())
        .name(user.getName())
        .email(user.getEmail())
        .build();
  }
}
