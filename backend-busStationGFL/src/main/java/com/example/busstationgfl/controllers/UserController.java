package com.example.busstationgfl.controllers;

import com.example.busstationgfl.dtos.user.UserDto;
import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.services.interfaces.user.RoleService;
import com.example.busstationgfl.services.interfaces.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
@AllArgsConstructor
@Log4j2
public class UserController {
    private UserService userService;
    private RoleService roleService;

    @GetMapping
    List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    UserDto findByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/Driver")
    List<UserDto> findAllDrivers() {
        return userService.findAllByRole(roleService.findByName("Driver"));
    }

    @PostMapping
    User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") long id) {
        userService.deleteById(id);
    }
}
