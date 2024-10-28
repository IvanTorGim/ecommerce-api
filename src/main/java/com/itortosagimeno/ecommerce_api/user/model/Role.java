package com.itortosagimeno.ecommerce_api.user.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
    ADMIN, USER;

    @JsonCreator
    public static Role fromString(String value) {
        return Role.valueOf(value.toUpperCase());
    }
}
