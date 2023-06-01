package com.example.planner.service;

import com.example.planner.dto.CreateUserDto;
import com.example.planner.dto.CreatedUserDto;
import com.example.planner.entities.Role;
import com.example.planner.entities.User;
import com.example.planner.exception.UserAlreadyExistsException;
import com.example.planner.exception.UserNotExistsException;
import com.example.planner.repositories.UserRepository;
import com.example.planner.utils.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
  private final UserRepository userRepository;
  private final BCryptPasswordEncoder encoder;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + "not found!"));
  }

  public User findUserByUsername(String username) {
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User with username " + username
            + "not found!"));
  }

  public User findUserById(UUID id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new UserNotExistsException(id));
  }

  public List<User> allUsers() {
    return userRepository.findAll();
  }

  public CreatedUserDto createNewUser(CreateUserDto createUserDto) {
    User user = User.builder()
        .username(createUserDto.getUsername())
        .password(createUserDto.getPassword())
        .name(createUserDto.getName())
        .email(createUserDto.getEmail())
        .build();

    return UserConverter.fromUserToCreated(saveNewUser(user));
  }

  public User saveNewUser(User user) {
    if (userRepository.existsByUsername(user.getUsername())) {
      throw new UserAlreadyExistsException(user.getUsername());
    }

    user.setPassword(encoder.encode(user.getPassword()));
    user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
    return userRepository.save(user);
  }
}
