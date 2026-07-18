package com.ems.backend.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
    }

    @Override
    public String updateEmployee(Long id, EmployeeDto employeeDto) {

    Employee employee = employeeRepository.findById(id) .orElseThrow(() -> new RuntimeException("Employee Not Found"));

    employee.setFirstName(employeeDto.getFirstName());
    employee.setLastName(employeeDto.getLastName());
    employee.setEmail(employeeDto.getEmail());
    employee.setPhone(employeeDto.getPhone());
    employee.setDepartment(employeeDto.getDepartment());
    employee.setDesignation(employeeDto.getDesignation());
    employee.setSalary(employeeDto.getSalary());
    employee.setAddress(employeeDto.getAddress());
    employee.setProfileImage(employeeDto.getProfileImage());

    employeeRepository.save(employee);

    return "Employee Updated Successfully";
  }

  @Override
    public String deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id) .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        employeeRepository.delete(employee);

    return "Employee Deleted Successfully";
  }
}