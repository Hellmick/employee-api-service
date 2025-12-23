package com.hellmick.employeeservice.dto.error;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GlobalErrorResponseDto(
        @NotBlank
        LocalDateTime timestamp,

        @NotBlank
        Integer status,

        @NotBlank
        String message,

        String error,

        @NotBlank
        String path
) {
}
