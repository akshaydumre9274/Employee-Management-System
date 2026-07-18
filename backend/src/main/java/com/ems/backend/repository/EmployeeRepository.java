package com.ems.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);

    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrDepartmentContainingIgnoreCase(
            String firstName,
            String lastName,
            String email,
            String department
    );

}