package com.itortosagimeno.ecommerce_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException exception) {
        ApiException apiException = ApiException.builder()
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .time(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
