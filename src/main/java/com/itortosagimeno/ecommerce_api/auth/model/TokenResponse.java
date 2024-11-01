package com.itortosagimeno.ecommerce_api.auth.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response containing an access token for the authenticated user.")
public record TokenResponse(
        @Schema(description = "JWT access token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        String accessToken
) {
}
