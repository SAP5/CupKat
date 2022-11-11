package com.example.cupcat.exception.errors;

public class AlreadyExistingException extends RuntimeException{
    public AlreadyExistingException(String message) {
        super(message);
    }
}
