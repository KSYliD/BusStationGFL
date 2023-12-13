package com.example.busstationgfl.services.user;

import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public User getUserById(long id) {
        System.out.println("UserDto by id");
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("All users");
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateById(long id, User userDetails) { //TODO: update
        User user = getUserById(id);
        user.setFirstName(userDetails.getFirstName());
        user.setSecondName(userDetails.getSecondName());
        user.setRole(userDetails.getRole());
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

}
