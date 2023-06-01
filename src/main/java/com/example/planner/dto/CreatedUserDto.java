package com.example.planner.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CreatedUserDto {
  private UUID id;
  private String username;
  private String name;
  private String email;
}
