package com.example.planner.repositories;

import com.example.planner.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
