package com.ems.backend.serviceimpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ems.backend.dto.LoginRequest;
import com.ems.backend.dto.LoginResponse;
import com.ems.backend.dto.UserDto;
import com.ems.backend.entity.User;
import com.ems.backend.repository.UserRepository;
import com.ems.backend.service.UserService;
import com.ems.backend.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String registerUser(UserDto userDto) {

        if (userRepository.existsByEmail(userDto.getEmail())) {
            return "Email already exists";
        }

        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(userDto.getRole())
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new LoginResponse(
                "Login Successful",
                token,
                user.getRole().name(),
                user.getEmail()
        );
    }
}