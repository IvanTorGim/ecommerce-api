package com.itortosagimeno.ecommerce_api.product.model;

import com.itortosagimeno.ecommerce_api.user.model.AddressResponse;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Integer Id,
        LocalDateTime dateTime,
        AddressResponse address,
        List<OrderProductResponse> products
) {
}
