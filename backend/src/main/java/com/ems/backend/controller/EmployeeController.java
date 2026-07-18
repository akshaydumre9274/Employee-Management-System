package com.ems.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ems.backend.dto.EmployeeDto;
import com.ems.backend.entity.Employee;
import com.ems.backend.service.EmployeeService;
import com.ems.backend.service.FileStorageService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final FileStorageService fileStorageService;

    public EmployeeController(EmployeeService employeeService,
                              FileStorageService fileStorageService) {

        this.employeeService = employeeService;
        this.fileStorageService = fileStorageService;
    }

    // Add Employee
    @PostMapping
    public String addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    // Upload Profile Image
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file)
            throws IOException {

        return fileStorageService.uploadFile(file);
    }

    // Get All Employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @RequestBody EmployeeDto employeeDto) {

        return employeeService.updateEmployee(id, employeeDto);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        return employeeService.deleteEmployee(id);
    }

    // Search Employee
    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String keyword) {

        return employeeService.searchEmployees(keyword);
    }

    // Pagination + Sorting
    @GetMapping
    public Page<Employee> getEmployees(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return employeeService.getEmployees(page, size, sortBy);
    }
}