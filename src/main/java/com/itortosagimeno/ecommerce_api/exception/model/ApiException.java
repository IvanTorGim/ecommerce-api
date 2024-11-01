package com.itortosagimeno.ecommerce_api.exception.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Represents an error response for the API")
public record ApiException(
        @Schema(description = "Error type", example = "Not Found")
        String error,
        @Schema(description = "Detailed error message", example = "Product with ID 30 not found")
        String message,
        @Schema(description = "HTTP status code", example = "400")
        Integer status,
        @Schema(description = "Timestamp of the error occurrence", example = "2024-11-01T02:28:19.910214161")
        LocalDateTime time
) {
}
