package com.ems.backend.controller;

import org.springframework.web.bind.annotation.*;

import com.ems.backend.dto.LoginRequest;
import com.ems.backend.dto.LoginResponse;
import com.ems.backend.dto.UserDto;
import com.ems.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }
}