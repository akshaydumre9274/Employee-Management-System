package com.ems.backend.dto;

import com.ems.backend.entity.Role;

import lombok.Data;

@Data
public class UserDto {

    private String name;

    private String email;

    private String password;

    private Role role;

}