package com.isyoudwn.simplemarketmono.order.exception;

import com.isyoudwn.simplemarketmono.common.response.ResponseMessage;

public class OrderExcepction extends RuntimeException{

    private final ResponseMessage responseMessage;

    public OrderExcepction(ResponseMessage responseMessage) {
        super(responseMessage.getMessage());
        this.responseMessage = responseMessage;
    }

    public String getCode() {
        return responseMessage.getCode();
    }
}
