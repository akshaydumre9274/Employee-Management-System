package com.ems.backend.service;

import java.util.List;

import com.ems.backend.dto.EmployeeDto;
import com.ems.backend.entity.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    String addEmployee(EmployeeDto employeeDto);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    String updateEmployee(Long id, EmployeeDto employeeDto);

     String deleteEmployee(Long id);

     List<Employee> searchEmployees(String keyword);

     Page<Employee> getEmployees(int page, int size, String sortBy);
}