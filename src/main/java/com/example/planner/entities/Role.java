package com.example.planner.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name")
  private String name;
  @ManyToMany(mappedBy = "roles")
  private Set<User> users;

  @Override
  public String getAuthority() {
    return null;
  }

  public Role(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
