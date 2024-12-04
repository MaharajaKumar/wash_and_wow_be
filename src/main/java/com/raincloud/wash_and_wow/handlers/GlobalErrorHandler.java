package com.raincloud.wash_and_wow.handlers;

import com.raincloud.wash_and_wow.dto.response.StatusResponse;
import com.raincloud.wash_and_wow.dto.response.ValidationErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StatusResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<ValidationErrorResponse> validationErrors = new ArrayList<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            ValidationErrorResponse errorResponse = new ValidationErrorResponse(fieldError.getField(), fieldError.getDefaultMessage());
            validationErrors.add(errorResponse);
        }
        return ResponseEntity.badRequest().body(StatusResponse.validationError("Validation Error", validationErrors));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StatusResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        List<ValidationErrorResponse> validationErrors = new ArrayList<>();
        for (ConstraintViolation<?> cv : ex.getConstraintViolations()) {
            ValidationErrorResponse errorResponse = new ValidationErrorResponse(cv.getPropertyPath().toString(), cv.getMessage());
            validationErrors.add(errorResponse);
        }
        return ResponseEntity.badRequest().body(StatusResponse.validationError("Validation error", validationErrors));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StatusResponse> handleEntityNotFoundException(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(StatusResponse.failure(ex.getMessage()));
    }
}