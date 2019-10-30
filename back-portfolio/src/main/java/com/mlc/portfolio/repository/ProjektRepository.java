package com.mlc.portfolio.repository;

import com.mlc.portfolio.models.Projekt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjektRepository extends JpaRepository<Projekt, Long> {

}
