package com.kostin.first.service;

import com.kostin.first.entities.ProgLanguage;
import java.util.List;

public interface ProgLanguageService {
    List<ProgLanguage> getAllProgLanguages();
    ProgLanguage getProgLanguageById(Integer id);
    ProgLanguage createProgLanguage(ProgLanguage progLanguage);
    void deleteProgLanguageById(Integer id);
}
