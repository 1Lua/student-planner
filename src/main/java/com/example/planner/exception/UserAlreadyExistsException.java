package com.example.planner.exception;

import java.util.UUID;

public class UserAlreadyExistsException extends RuntimeException {
  public UserAlreadyExistsException(String username) {
    super("User with username " + username + " already exists!");
  }
}
