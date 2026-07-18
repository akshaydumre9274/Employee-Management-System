package com.ems.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.ems.backend.dto.EmployeeDto;
import com.ems.backend.entity.Employee;
import com.ems.backend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Add Employee
    @PostMapping
    public String addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    // Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

     // update Employee By ID
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto)
     {
        return employeeService.updateEmployee(id, employeeDto);
     }

    // Delete Employee By ID
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id)
    {
        return employeeService.deleteEmployee(id);
    }

    //search employee
    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String keyword) {
    return employeeService.searchEmployees(keyword);
}

}