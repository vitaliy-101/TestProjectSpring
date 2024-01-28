package com.kostin.first.mapper;

import com.kostin.first.dtos.developer.DeveloperDtoIn;
import com.kostin.first.entities.Developer;
import com.kostin.first.entities.ProgLanguage;
import com.kostin.first.service.ProgLanguageReadService;
import com.kostin.first.service.ProgLanguageServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeveloperDtoConverter extends DtoConverter{
    @Autowired
    private ProgLanguageReadService progLanguageService;
    public Developer convertFromDtoIn(DeveloperDtoIn developerDtoIn){
        Developer developer = simpleConvert(developerDtoIn, Developer.class);
        List<ProgLanguage> progLanguages = new ArrayList<>();
        for (Integer id : developerDtoIn.getProgLanguagesIds()){
            progLanguages.add(progLanguageService.getProgLanguageById(id));
        }
        developer.setProgLanguages(progLanguages);
        return developer;
    }
}
