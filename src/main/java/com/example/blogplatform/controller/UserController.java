package com.example.blogplatform.controller;

import com.example.blogplatform.model.User;
import com.example.blogplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.registerUser(user);
    }

    @GetMapping("/find")
    public User findUser(@RequestParam String userName) {
        return userService.findUserByUserName(userName).orElse(null);
    }
}
