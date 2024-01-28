package com.kostin.first.repositories;

import com.kostin.first.entities.ProgLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgLanguageRepository extends JpaRepository<ProgLanguage, Integer> {
    boolean existsByName(String name);

}
