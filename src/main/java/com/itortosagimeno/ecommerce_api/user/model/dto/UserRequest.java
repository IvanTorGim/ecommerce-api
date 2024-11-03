package com.itortosagimeno.ecommerce_api.user.model.dto;

import com.itortosagimeno.ecommerce_api.user.model.common.Role;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request DTO for creating or updating a user")
public record UserRequest(
        @Schema(description = "Full name of the user", example = "John Doe")
        String name,
        @Schema(description = "Email address of the user", example = "user@example.com")
        String email,
        @Schema(description = "Password for the user's account", example = "securePassword123")
        String password,
        @Schema(description = "Role assigned to the user", example = "USER")
        Role role
) {
}
