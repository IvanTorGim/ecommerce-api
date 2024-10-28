package com.itortosagimeno.ecommerce_api.auth.model;

import com.itortosagimeno.ecommerce_api.user.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Builder
public record RegisterRequest(
        @NotBlank String name,
        @Email String email,
        @Length(min = 6) String password,
        @NotNull Role role
) {
}