package com.hellmick.employeeservice.controller;

import com.hellmick.employeeservice.dto.employee.CreateEmployeeRequestDto;
import com.hellmick.employeeservice.dto.employee.EmployeeListResponseDto;
import com.hellmick.employeeservice.dto.employee.EmployeeResponseDto;
import com.hellmick.employeeservice.dto.employee.UpdateEmployeeRequestDto;
import com.hellmick.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // GET /api/v1/employees
    @GetMapping
    public ResponseEntity<List<EmployeeListResponseDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // GET /api/v1/employees/{id}
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable UUID id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // POST /api/v1/employees
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(
            @Valid @RequestBody CreateEmployeeRequestDto request) {
        EmployeeResponseDto created = employeeService.createEmployee(request);
        return ResponseEntity.ok(created);
    }

    // PUT /api/v1/employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateEmployeeRequestDto request) {
        EmployeeResponseDto updated = employeeService.updateEmployee(id, request);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/v1/employees/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
