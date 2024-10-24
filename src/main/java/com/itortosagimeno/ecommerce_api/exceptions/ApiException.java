package com.itortosagimeno.ecommerce_api.exceptions;

import java.time.ZonedDateTime;

public record ApiException(
        String error,
        String message,
        Integer status,
        ZonedDateTime time
) {
}
