package com.kostin.first.controllers;

import com.kostin.first.dtos.user.UserDto;
import com.kostin.first.dtos.user.UserDtoIn;
import com.kostin.first.entities.User;
import com.kostin.first.mapper.DtoConverter;
import com.kostin.first.service.UserService;
import com.kostin.first.service.UserServiceImpl;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DtoConverter dtoConverter;
    @GetMapping
    public List<UserDto> getAll(){
        return dtoConverter.simpleConvert(userService.getAll(), UserDto.class);
    }
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return dtoConverter.simpleConvert(userService.getUserById(id), UserDto.class);
    }
    @PostMapping
    public UserDto createUser(@Validated @RequestBody UserDtoIn user){
        return dtoConverter.simpleConvert(userService.createUser(dtoConverter.simpleConvert(user, User.class)), UserDto.class);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public UserDto updateUser(@Valid @RequestBody UserDtoIn user, @PathVariable Integer id){
        return dtoConverter.simpleConvert(userService.updateUser(dtoConverter.simpleConvert(user, User.class), id), UserDto.class);
    }

    


}
