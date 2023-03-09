package com.example.restfulProject.Controller;

import com.example.restfulProject.Model.User;
import com.example.restfulProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        userRepository.save(user);
        return "Saved...";
    }

    @GetMapping(value = "/user/{username}")
    public List<User> getUser(@PathVariable String username) {
        return userRepository.findAllByUsername(username);
    }

    @PutMapping(value = "/update/{username}")
    public String updateUser(@PathVariable String username, @RequestBody User user) {
        User updateUser = userRepository.findByUsername(username);
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        updateUser.setName(user.getName());
        updateUser.setAddress(user.getAddress());
        userRepository.save(updateUser);
        return "Updated...";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping(value = "/delete/{userID}")
    public String deleteUser(@PathVariable long userID) {
        User deleteUser = userRepository.findById(userID).get();
        userRepository.delete(deleteUser);
        return "User Deleted...";
    }
}