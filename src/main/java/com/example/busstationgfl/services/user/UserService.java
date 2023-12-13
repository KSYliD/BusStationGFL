package com.example.busstationgfl.services.user;

import com.example.busstationgfl.entities.user.User;

import java.util.List;

public interface UserService {
    User getUserById(long id);
    List<User> getAllUsers();
    User save(User user);
    void updateById(long id, User userDetails);
    void deleteById(long id);
}
