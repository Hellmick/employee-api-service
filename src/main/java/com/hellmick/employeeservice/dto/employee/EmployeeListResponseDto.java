package com.hellmick.employeeservice.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record EmployeeListResponseDto(
    @NotBlank
    UUID id,

    @NotBlank
    String firstName,

    @NotBlank
    String lastName,

    @NotBlank
    @Email
    String email,

    String department,

    @Positive
    BigDecimal salary
) {}
