package com.genai.lms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@GetMapping("/")
    public String home() {
        return "GenAI LMS Backend Running";
    }
	
	@GetMapping("/login")
	public String login() {
		return "Login Success";
	}
}
