package com.itortosagimeno.ecommerce_api.product.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Integer Id,
        LocalDateTime dateTime,
        Integer addressId,
        List<OrderProductResponse> products
) {
}
