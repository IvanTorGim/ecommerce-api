package com.itortosagimeno.ecommerce_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException exception) {
        ApiException apiException = new ApiException(
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
