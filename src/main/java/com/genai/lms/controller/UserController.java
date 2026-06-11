package com.genai.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.genai.lms.dto.LoginRequest;
import com.genai.lms.entity.User;
import com.genai.lms.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }
    @GetMapping("/profile")
    public String profile() {
        return "Protected Profile Accessed";
    }
}