package com.hellmick.employeeservice.service;

import com.hellmick.employeeservice.dto.employee.CreateEmployeeRequestDto;
import com.hellmick.employeeservice.dto.employee.EmployeeListResponseDto;
import com.hellmick.employeeservice.dto.employee.EmployeeResponseDto;
import com.hellmick.employeeservice.dto.employee.UpdateEmployeeRequestDto;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<EmployeeListResponseDto> getAllEmployees();

    EmployeeResponseDto getEmployeeById(UUID id);

    EmployeeResponseDto createEmployee(CreateEmployeeRequestDto dto);

    EmployeeResponseDto updateEmployee(UUID id, UpdateEmployeeRequestDto dto);

    void deleteEmployee(UUID id);
}
