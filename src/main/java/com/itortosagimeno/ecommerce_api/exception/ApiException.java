package com.itortosagimeno.ecommerce_api.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ApiException(
        String error,
        String message,
        Integer status,
        LocalDateTime time
) {
}
