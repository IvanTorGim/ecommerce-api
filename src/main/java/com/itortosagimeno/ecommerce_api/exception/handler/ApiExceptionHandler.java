package com.itortosagimeno.ecommerce_api.exception.handler;

import com.itortosagimeno.ecommerce_api.exception.custom.OrderNotFoundException;
import com.itortosagimeno.ecommerce_api.exception.custom.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.exception.custom.UserExistsException;
import com.itortosagimeno.ecommerce_api.exception.custom.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.exception.model.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiException> handleProductNotFoundException(ProductNotFoundException e) {
        final var apiException = new ApiException(
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(apiException);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<ApiException> handleUserException(UserExistsException e) {
        final var apiException = new ApiException(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(apiException);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiException> handleUserNotFoundException(UserNotFoundException e) {
        final var apiException = new ApiException(
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(apiException);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ApiException> handleOrderNotFoundException(OrderNotFoundException e) {
        final var apiException = new ApiException(
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(apiException);
    }
}
