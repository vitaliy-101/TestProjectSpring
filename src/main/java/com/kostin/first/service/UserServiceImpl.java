package com.kostin.first.service;

import com.kostin.first.entities.Phone;
import com.kostin.first.entities.User;
import com.kostin.first.exceptions.FoundException;
import com.kostin.first.exceptions.NotFoundByIdException;
import com.kostin.first.repositories.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService, UserReadService{
    @Autowired
    private UserRepository userRepository;
    @Scheduled(fixedRate = 10000)
    public void printUser(){
        List<User> users = userRepository.findAll();
        System.out.println(users.stream().flatMap(user -> user.getPhones().stream()).map(Phone::getModel).toList());
    }

    @Override
    public List<User> getAll(){
        List<User> users = userRepository.findAll();
        System.out.println(users.stream().flatMap(user -> user.getPhones().stream()).map(Phone::getModel).toList());
        return users;
    }
    @Override
    public User getUserById(Integer id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundByIdException(User.class, id));
    }
    @Override
    public User createUser(User user){
        if (userRepository.existsByName(user.getName())){
            throw new FoundException(User.class, user.getName());
        }
        return userRepository.save(user);
    }
    @Override
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
    @Override
    public User updateUser(User user, Integer id){
        User lastUser = userRepository.findById(id).orElseThrow(() -> new NotFoundByIdException(User.class, id));
        if (!lastUser.getName().equals(user.getName()) && userRepository.existsByName(user.getName())){
            throw new FoundException(User.class, user.getName());
        }
        lastUser.setText(user.getText());
        lastUser.setAge(user.getAge());
        lastUser.setName(user.getName());
        return userRepository.save(lastUser);
    }

}
