package com.ritik.loanservice.exception;

public class LoanAlreadyExistsException extends RuntimeException {
    public LoanAlreadyExistsException(String ex) {
        super(ex);
    }
}
