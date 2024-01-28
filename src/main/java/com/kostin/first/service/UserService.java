package com.kostin.first.service;

import com.kostin.first.entities.User;
import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(Integer id);
    User createUser(User user);
    void deleteUser(Integer id);
    User updateUser(User user, Integer id);


}
