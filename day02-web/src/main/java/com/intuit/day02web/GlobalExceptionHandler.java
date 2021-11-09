package com.intuit.day02web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static Logger Log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ArithmeticException.class)
    public HttpEntity<ErrorInformation> handleException(ArithmeticException ex, WebRequest req) {
        Log.error("Arithmetic exception {} occured in {}", ex.getMessage(), req.getDescription(false));
        ErrorInformation info = new ErrorInformation();
        info.setReason(ex.getMessage());
        info.setPath(req.getDescription(false));
        info.setTimestamp(Instant.now().toString());
        return new ResponseEntity<>(info, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public HttpEntity<ErrorInformation> handleException(Exception ex, WebRequest req) {
        Log.error("Exception {} occured in {}", ex.getMessage(), req.getDescription(false));
        ErrorInformation info = new ErrorInformation();
        info.setReason("ERROR: " + ex.getMessage());
        info.setPath(req.getDescription(false));
        info.setTimestamp(Instant.now().toString());
        return new ResponseEntity<>(info, HttpStatus.NOT_ACCEPTABLE);
    }
}
