package com.ems.backend.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;
    private String designation;
    private Double salary;
    private String address;
    private String profileImage;
}