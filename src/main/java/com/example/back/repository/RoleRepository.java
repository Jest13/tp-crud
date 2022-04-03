package com.example.back.repository;

import com.example.back.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long > {
    Role findByName(String name);
}
