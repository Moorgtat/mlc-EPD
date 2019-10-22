package com.mlc.portfolio.repository;

import com.mlc.portfolio.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository {
    Optional findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
