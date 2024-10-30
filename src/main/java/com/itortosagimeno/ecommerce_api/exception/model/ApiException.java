package com.itortosagimeno.ecommerce_api.exception.model;

import java.time.LocalDateTime;

public record ApiException(
        String error,
        String message,
        Integer status,
        LocalDateTime time
) {
}
