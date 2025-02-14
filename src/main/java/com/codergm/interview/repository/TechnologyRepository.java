package com.codergm.interview.repository;

import com.codergm.interview.model.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
