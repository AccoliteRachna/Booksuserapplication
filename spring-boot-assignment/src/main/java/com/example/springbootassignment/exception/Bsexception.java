package com.example.springbootassignment.exception;

public class Bsexception extends RuntimeException{
    private static final long serviceVersionUID = 1L;

    public Bsexception(String message){
        super(message);
    }

    public Bsexception(String message, Throwable throwable) {
        super(message, throwable);
    }
}
