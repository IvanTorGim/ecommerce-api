package com.itortosagimeno.ecommerce_api.auth.model;

import com.itortosagimeno.ecommerce_api.user.model.common.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Request body for registering a new user, including name, email, password, and role.")
public record RegisterRequest(
        @NotBlank
        @Schema(description = "User's full name", example = "John Doe", requiredMode = REQUIRED)
        String name,

        @Email
        @Schema(description = "User's email address", example = "john.doe@example.com", requiredMode = REQUIRED)
        String email,

        @Length(min = 6)
        @Schema(description = "Password with at least 6 characters", example = "securePass123", requiredMode = REQUIRED)
        String password,

        @NotNull
        @Schema(description = "Role assigned to the user", example = "USER", requiredMode = REQUIRED)
        Role role
) {
}