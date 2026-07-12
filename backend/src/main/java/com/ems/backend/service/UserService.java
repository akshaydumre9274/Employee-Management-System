package com.ems.backend.service;

import com.ems.backend.dto.LoginRequest;
import com.ems.backend.dto.LoginResponse;
import com.ems.backend.dto.UserDto;

public interface UserService {

    String registerUser(UserDto userDto);

    LoginResponse loginUser(LoginRequest loginRequest);

}