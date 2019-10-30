package com.mlc.portfolio.repository;

import com.mlc.portfolio.models.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRepository extends JpaRepository<Identity, Long> {

    Identity findFirstById(Integer id);
}
