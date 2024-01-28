package com.kostin.first.service;

import com.kostin.first.entities.ProgLanguage;
import com.kostin.first.exceptions.FoundException;
import com.kostin.first.exceptions.NotFoundByIdException;
import com.kostin.first.repositories.ProgLanguageRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgLanguageServiceImpl implements ProgLanguageService, ProgLanguageReadService{
    @Autowired
    private ProgLanguageRepository progLanguageRepository;
    public List<ProgLanguage> getAllProgLanguages(){
        return progLanguageRepository.findAll();
    }
    public ProgLanguage getProgLanguageById(Integer id){
        return progLanguageRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(ProgLanguage.class, id));
    }
    public ProgLanguage createProgLanguage(ProgLanguage progLanguage){
        if (progLanguageRepository.existsByName(progLanguage.getName())){
            throw new FoundException(ProgLanguage.class, progLanguage.getName());
        }
        return progLanguageRepository.save(progLanguage);
    }
    public void deleteProgLanguageById(Integer id){
        progLanguageRepository.deleteById(id);
    }
}
