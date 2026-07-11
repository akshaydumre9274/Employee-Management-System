package com.ems.backend.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.backend.dto.UserDto;
import com.ems.backend.entity.User;
import com.ems.backend.repository.UserRepository;
import com.ems.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String registerUser(UserDto userDto) {

        if (userRepository.existsByEmail(userDto.getEmail())) {
            return "Email already exists";
        }

        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword()) // BCrypt later
                .role(userDto.getRole())
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }

}