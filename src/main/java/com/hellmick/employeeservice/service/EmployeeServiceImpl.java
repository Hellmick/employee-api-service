package com.hellmick.employeeservice.service;

import com.hellmick.employeeservice.dto.employee.CreateEmployeeRequestDto;
import com.hellmick.employeeservice.dto.employee.EmployeeListResponseDto;
import com.hellmick.employeeservice.dto.employee.EmployeeResponseDto;
import com.hellmick.employeeservice.dto.employee.UpdateEmployeeRequestDto;
import com.hellmick.employeeservice.entity.Employee;
import com.hellmick.employeeservice.exception.business.EmployeeNotFoundException;
import com.hellmick.employeeservice.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeListResponseDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::toEmployeeListResponseDto)
                .toList();
    }

    @Override
    public EmployeeResponseDto getEmployeeById(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        return toEmployeeResponseDto(employee);
    }

    @Override
    public EmployeeResponseDto createEmployee(CreateEmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.firstName());
        employee.setLastName(dto.lastName());
        employee.setEmail(dto.email());
        employee.setDepartment(dto.department());
        employee.setSalary(dto.salary());

        Employee saved = employeeRepository.save(employee);
        return toEmployeeResponseDto(saved);
    }

    @Override
    public EmployeeResponseDto updateEmployee(UUID id, UpdateEmployeeRequestDto dto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        employee.setFirstName(dto.firstName());
        employee.setLastName(dto.lastName());
        employee.setDepartment(dto.department());
        employee.setSalary(dto.salary());
        employee.setEmail(dto.email());

        return toEmployeeResponseDto(employee);
    }

    @Override
    public void deleteEmployee(UUID id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }

    private EmployeeListResponseDto toEmployeeListResponseDto(Employee employee) {
        return new EmployeeListResponseDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }

    private EmployeeResponseDto toEmployeeResponseDto(Employee employee) {
        return new EmployeeResponseDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary(),
                employee.getCreatedAt(),
                employee.getUpdatedAt()
        );
    }
}
