package ru.geekbrains.springlesson2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        BookstoreError bookstoreError = new BookstoreError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(bookstoreError, HttpStatus.NOT_FOUND);
    }
}

