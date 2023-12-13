package com.example.busstationgfl.controllers;

import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
@AllArgsConstructor
public class UserController {
    UserService userService;

    @GetMapping
    List<User> getAllUsers(){
      return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
    @PostMapping
    User save(@RequestBody User user){
        return userService.save(user);
    }
    @PutMapping("/{id}")
    void update(@PathVariable long id, @RequestBody User userDetails){
        userService.updateById(id, userDetails);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable long id){
        userService.deleteById(id);
    }
}
