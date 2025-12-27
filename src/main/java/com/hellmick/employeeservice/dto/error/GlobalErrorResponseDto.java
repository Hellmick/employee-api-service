package com.hellmick.employeeservice.dto.error;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public record GlobalErrorResponseDto(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {}
