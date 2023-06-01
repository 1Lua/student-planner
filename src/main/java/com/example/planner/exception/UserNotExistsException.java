package com.example.planner.exception;

import java.util.UUID;

public class UserNotExistsException extends RuntimeException {

  public UserNotExistsException(String username) {
    super("User with username " + username + " doesn't exist!.");
  }

  public UserNotExistsException(UUID id) {
    super("User with id " + id + " doesn't exist!.");
  }
}
