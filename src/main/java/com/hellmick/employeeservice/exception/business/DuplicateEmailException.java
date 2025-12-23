package com.hellmick.employeeservice.exception.business;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {

        super("Employee with the email " + email + " already exists.");
    }
}
