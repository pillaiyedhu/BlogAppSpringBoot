package com.blogapplication.app.exception;

import com.blogapplication.app.payload.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException rx){
        String msg = rx.getMessage();
        ApiResponse apiResponse = new ApiResponse(msg, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Set<String>> constraintViolationException(ConstraintViolationException cx){
        Set<ConstraintViolation<?>> constraintViolations = cx.getConstraintViolations();
        Set<String> message = new HashSet<>(constraintViolations.size());
        message.addAll(constraintViolations.stream().map(constraintViolation ->
            String.format("%s ",constraintViolation.getMessage())
        ).collect(Collectors.toList()));
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
}
