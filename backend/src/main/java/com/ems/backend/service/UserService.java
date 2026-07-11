package com.ems.backend.service;

import com.ems.backend.dto.UserDto;

public interface UserService {

    String registerUser(UserDto userDto);

}