package com.itortosagimeno.ecommerce_api.auth.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Builder
public record RegisterRequestDTO(
        @NotBlank String name,
        @Email String email,
        @Length(min = 6) String password
) {
}