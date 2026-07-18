package com.ems.backend.service;

import java.util.List;

import com.ems.backend.dto.EmployeeDto;
import com.ems.backend.entity.Employee;

public interface EmployeeService {

    String addEmployee(EmployeeDto employeeDto);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    String updateEmployee(Long id, EmployeeDto employeeDto);

     String deleteEmployee(Long id);
}