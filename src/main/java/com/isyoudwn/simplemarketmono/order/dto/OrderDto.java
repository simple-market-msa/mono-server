package com.isyoudwn.simplemarketmono.order.dto;

import java.util.List;

public class OrderDto {
    public record OrderRequest(
            Integer quantity,
            String productId
    ) {
    }

    public record MyOrders(
            Long orderId,
            List<OrderProductDto> orders
    ) {
    }

    public record OrderProductDto(
            Integer quantity,
            String productName
    ) {
    }
}
