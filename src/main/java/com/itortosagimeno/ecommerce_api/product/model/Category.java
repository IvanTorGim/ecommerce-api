package com.itortosagimeno.ecommerce_api.product.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {
    ELECTRONICS, WEARABLES, AUDIO, ACCESSORIES, HOME;

    @JsonCreator
    public static Category fromString(String value) {
        return Category.valueOf(value.toUpperCase());
    }
}