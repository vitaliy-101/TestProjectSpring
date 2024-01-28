package com.kostin.first.controllers;

import com.kostin.first.dtos.progLanguage.ProgLanguageDto;
import com.kostin.first.dtos.progLanguage.ProgLanguageDtoIn;
import com.kostin.first.entities.ProgLanguage;
import com.kostin.first.mapper.DtoConverter;
import com.kostin.first.service.ProgLanguageService;
import com.kostin.first.service.ProgLanguageServiceImpl;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/progLanguage")
public class ProgLanguageController {
    @Autowired
    private ProgLanguageService service;
    @Autowired
    private DtoConverter dtoConverter;
    @GetMapping
    private List<ProgLanguageDto> getAllProgLanguages(){
        return dtoConverter.simpleConvert(service.getAllProgLanguages(), ProgLanguageDto.class);
    }
    @GetMapping("/{id}")
    private ProgLanguageDto getAllProgLanguages(@PathVariable Integer id){
        return dtoConverter.simpleConvert(service.getProgLanguageById(id), ProgLanguageDto.class);
    }
    @PostMapping
    private ProgLanguageDto createProgLanguage(@Valid @RequestBody ProgLanguageDtoIn progLanguage){
        return dtoConverter.simpleConvert(service.createProgLanguage(dtoConverter.simpleConvert(progLanguage, ProgLanguage.class)), ProgLanguageDto.class);
    }
    @DeleteMapping("/{id}")
    public void deleteProgLanguageById(Integer id){
        service.deleteProgLanguageById(id);
    }
}
