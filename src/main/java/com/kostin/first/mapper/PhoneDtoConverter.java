package com.kostin.first.mapper;

import com.kostin.first.dtos.phone.PhoneDtoIn;
import com.kostin.first.entities.Phone;
import com.kostin.first.service.UserReadService;
import com.kostin.first.service.UserService;
import com.kostin.first.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneDtoConverter extends DtoConverter{
    @Autowired
    private UserReadService userService;
    public Phone convertFromDtoIn(PhoneDtoIn phoneDtoIn){
        Phone phone = simpleConvert(phoneDtoIn, Phone.class);
        phone.setUser(userService.getUserById(phoneDtoIn.getUserId()));
        return phone;
    }
}

