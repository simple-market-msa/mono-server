package com.isyoudwn.simplemarketmono.common.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResponseMessage {

    // ORDER
    ORDER_SUCCESS("ORDER-0000", "주문은 완료했습니다."),

    // PRODUCT
    PRODUCT_STOCK_NOT_ENOUGH("PRODUCT-0000", "상품 개수가 충분하지 않습니다."),
    PRODUCT_NOT_FOUND("PRODUCT-0000", "존재하지 않는 상품입니다."),

    // MEMBER
    MEMBER_NOT_FOUND("MEMBER-0000", "존재하지 않는 유저입니다."),
    CREATE_MEMBER_SUCCESS("MEMBER-0001", "유저 생성을 성공했습니다");

    private final String code;
    private final String message;
}
