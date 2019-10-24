package com.mlc.portfolio.repository;

import java.util.Optional;

import com.mlc.portfolio.models.ERole;
import com.mlc.portfolio.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
