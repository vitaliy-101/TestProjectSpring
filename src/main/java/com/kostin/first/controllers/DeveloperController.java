
package com.kostin.first.controllers;

import com.kostin.first.dtos.developer.DeveloperDto;
import com.kostin.first.dtos.developer.DeveloperDtoIn;
import com.kostin.first.mapper.DeveloperDtoConverter;
import com.kostin.first.service.DeveloperService;
import com.kostin.first.service.DeveloperServiceImpl;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
    @Autowired
    private DeveloperService service;
    @Autowired
    private DeveloperDtoConverter converter;
    @GetMapping
    private List<DeveloperDto> getAllDevelopers(){
        return converter.simpleConvert(service.getAllDevelopers(), DeveloperDto.class);
    }
    @GetMapping("/{id}")
    private DeveloperDto getDeveloperById(@PathVariable Integer id){
        return converter.simpleConvert(service.getDeveloperById(id), DeveloperDto.class);
    }
    @PostMapping
    private DeveloperDto createDeveloper(@Valid @RequestBody DeveloperDtoIn developer){
        return converter.simpleConvert(service.createDeveloper(converter.convertFromDtoIn(developer)), DeveloperDto.class);
    }
    @DeleteMapping("/{id}")
    private void deleteDeveloperById(Integer id){
        service.deleteDeveloperById(id);
    }
    @PutMapping("/{id}")
    private DeveloperDto updateDeveloper(@Valid @RequestBody DeveloperDtoIn developer, @PathVariable Integer id){
        return converter.simpleConvert(service.updateDeveloper(converter.convertFromDtoIn(developer), id), DeveloperDto.class);
    }


}

