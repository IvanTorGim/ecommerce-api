package com.itortosagimeno.ecommerce_api.product.model.dto;

import com.itortosagimeno.ecommerce_api.user.model.dto.AddressResponse;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Integer Id,
        LocalDateTime dateTime,
        AddressResponse address,
        List<OrderProductResponse> products
) {
}
