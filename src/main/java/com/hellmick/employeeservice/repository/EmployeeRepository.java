package com.hellmick.employeeservice.repository;

import com.hellmick.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    public Optional<Employee> findByEmail(String email);
}
