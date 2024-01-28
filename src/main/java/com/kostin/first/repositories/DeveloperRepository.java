package com.kostin.first.repositories;

import com.kostin.first.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
    boolean existsByName(String name);
}
