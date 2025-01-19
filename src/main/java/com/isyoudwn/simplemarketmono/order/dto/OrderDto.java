package com.isyoudwn.simplemarketmono.order.dto;

public class OrderDto {
    public record OrderRequest(
            Integer quantity,
            String productId
    ) {};
}
