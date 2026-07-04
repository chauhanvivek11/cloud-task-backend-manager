package com.alight.cloudtaskmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Ye bouncer sirf Validation errors ko pakdega
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>(); // Ek khali dabba banaya

        // Jitne bhi errors aaye hain, un sabko dhoondh kar clean format mein dabbe mein daal do
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField(); // Kis field mein error hai (jaise 'title')
            String errorMessage = error.getDefaultMessage();    // Kya error hai
            errors.put(fieldName, errorMessage);
        });

        return errors; // Saaf-suthra dabba wapas bhej diya
    }
}