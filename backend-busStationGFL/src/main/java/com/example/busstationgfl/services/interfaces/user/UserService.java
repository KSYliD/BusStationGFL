package com.example.busstationgfl.services.interfaces.user;

import com.example.busstationgfl.dtos.user.UserDto;
import com.example.busstationgfl.entities.user.Role;
import com.example.busstationgfl.entities.user.User;

import java.util.List;

public interface UserService {
    UserDto getUserById(long id);
    List<UserDto> getAllUsers();
    User save(User user);
    void deleteById(long id);
    UserDto findByEmail(String email);
    List<UserDto> findAllByRole(Role role);
}
