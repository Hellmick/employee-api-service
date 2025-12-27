package com.hellmick.employeeservice.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateEmployeeRequestDto(
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
