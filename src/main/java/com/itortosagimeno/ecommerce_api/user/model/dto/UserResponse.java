package com.itortosagimeno.ecommerce_api.user.model.dto;

import com.itortosagimeno.ecommerce_api.user.model.common.Role;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response DTO for user details")
public record UserResponse(
        @Schema(description = "Unique identifier of the user", example = "1")
        Integer id,
        @Schema(description = "Email address of the user", example = "user@example.com")
        String email,
        @Schema(description = "Full name of the user", example = "John Doe")
        String name,
        @Schema(description = "Role assigned to the user", example = "ADMIN")
        Role role
) {
}