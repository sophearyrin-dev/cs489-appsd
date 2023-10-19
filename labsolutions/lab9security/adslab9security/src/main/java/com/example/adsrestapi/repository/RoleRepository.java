package com.example.adsrestapi.repository;

import com.example.adsrestapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findRoleByName(String name);
}
