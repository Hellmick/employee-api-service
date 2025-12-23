package com.hellmick.employeeservice.exception.validation;

import java.util.UUID;

public class ValidationException extends RuntimeException {
    public ValidationException (UUID id) {
        super("Entity not valid with id: " + id);
    }
}
