package com.genai.lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.genai.lms.dto.LoginRequest;
import com.genai.lms.entity.User;
import com.genai.lms.repository.UserRepository;
import com.genai.lms.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    public String loginUser(LoginRequest request) {

        Optional<User> optionalUser =
                userRepository.findByEmail(request.getEmail());

        if(optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = optionalUser.get();

        boolean match = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if(match) {
        	return JwtUtil.generateToken(user.getEmail());
        }

        throw new RuntimeException("Invalid Password");
    }
}