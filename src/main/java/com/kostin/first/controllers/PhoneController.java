package com.kostin.first.controllers;

import com.kostin.first.dtos.phone.PhoneDto;
import com.kostin.first.dtos.phone.PhoneDtoIn;
import com.kostin.first.mapper.PhoneDtoConverter;
import com.kostin.first.service.PhoneService;
import com.kostin.first.service.PhoneServiceImpl;
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
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private PhoneService service;
    @Autowired
    private PhoneDtoConverter converter;


    @GetMapping
    private List<PhoneDto> getAllPhones(){
        return converter.simpleConvert(service.getAllPhones(), PhoneDto.class);
    }
    @GetMapping("/sort")
    private List<PhoneDto> getAllPhonesSort(){
        return converter.simpleConvert(service.getAllPhonesSort(), PhoneDto.class);
    }
    @GetMapping("/{id}")
    private PhoneDto getPhoneById(@PathVariable Integer id){
        return converter.simpleConvert(service.getPhoneById(id), PhoneDto.class);
    }
    @PostMapping
    private PhoneDto createPhone(@Valid  @RequestBody PhoneDtoIn phone){
        return converter.simpleConvert(service.createPhone(converter.convertFromDtoIn(phone)), PhoneDto.class);
    }
    @DeleteMapping("/{id}")
    public void deletePhone(@PathVariable Integer id){
        service.deletePhone(id);
    }
    @PutMapping("/{id}")
    public PhoneDto updatePhone(@Valid @RequestBody PhoneDtoIn phone , @PathVariable Integer id){
        return converter.simpleConvert(service.updatePhone(converter.convertFromDtoIn(phone), id), PhoneDto.class);
    }



}
