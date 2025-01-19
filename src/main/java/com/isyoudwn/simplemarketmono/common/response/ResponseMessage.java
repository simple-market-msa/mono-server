package com.isyoudwn.simplemarketmono.common.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResponseMessage {
    ORDER_SUCCESS("ORDER-0000", "주문은 완료했습니다."),
    PRODUCT_STOCK_NOT_ENOUGH("PRODUCT-0000", "상품 개수가 충분하지 않습니다."),
    MEMBER_NOT_FOUND("MEMBER-0000", "존재하지 않는 유저입니다."),
    PRODUCT_NOT_FOUND("PRODUCT-0000", "존재하지 않는 상품입니다.");
    private final String code;
    private final String message;
}
