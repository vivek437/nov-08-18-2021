package com.intuit.day01web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public String handleWeirdException(ArithmeticException ex, WebRequest req) {
        String message = "Error occurred: " + ex.getMessage();
        return message;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public String handleException2(ArrayIndexOutOfBoundsException ex, WebRequest req) {
        String message = "Error occurred: " + ex.getMessage();
        return message;
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNPException(NullPointerException ex, WebRequest req) {
        String message = "Error occurred: " + ex.getMessage();
        return message;
    }
}
