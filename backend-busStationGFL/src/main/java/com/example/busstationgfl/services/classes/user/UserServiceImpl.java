package com.example.busstationgfl.services.classes.user;

import com.example.busstationgfl.dtos.user.UserDto;
import com.example.busstationgfl.entities.user.Role;
import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.mappers.UserMapper;
import com.example.busstationgfl.repositories.UserRepository;
import com.example.busstationgfl.services.interfaces.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto getUserById(long id) {
        return userMapper.userToUserDto(userRepository.getUserById(id));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::userToUserDto).collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findByEmail(String email) {
        return userMapper.userToUserDto(userRepository.findByEmail(email));
    }

    @Override
    public List<UserDto> findAllByRole(Role role) {
        return userRepository.findAllByRole(role).stream().map(userMapper::userToUserDto).collect(Collectors.toList());
    }


}
