package com.itortosagimeno.ecommerce_api.auth.model;

import lombok.Builder;

@Builder
public record TokenResponse(
        String accessToken
) {
}
