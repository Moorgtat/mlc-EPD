package com.mlc.portfolio.repository;

import com.mlc.portfolio.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Skill findById(int id);
}
