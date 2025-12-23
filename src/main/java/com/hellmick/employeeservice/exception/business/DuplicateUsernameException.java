package com.hellmick.employeeservice.exception.business;

public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException(String email) {

        super("Employee with the email " + email + " already exists.");
    }
}
