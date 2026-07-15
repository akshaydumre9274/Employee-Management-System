package com.ems.backend.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.ems.backend.dto.EmployeeDto;
import com.ems.backend.entity.Employee;
import com.ems.backend.repository.EmployeeRepository;
import com.ems.backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String addEmployee(EmployeeDto employeeDto) {

        if (employeeRepository.existsByEmail(employeeDto.getEmail())) {
            return "Employee already exists";
        }

        Employee employee = Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .phone(employeeDto.getPhone())
                .department(employeeDto.getDepartment())
                .designation(employeeDto.getDesignation())
                .salary(employeeDto.getSalary())
                .address(employeeDto.getAddress())
                .profileImage(employeeDto.getProfileImage())
                .createdAt(LocalDateTime.now())
                .build();

        employeeRepository.save(employee);

        return "Employee Added Successfully";
    }
}