package com.isyoudwn.simplemarketmono.product.exception;

import com.isyoudwn.simplemarketmono.common.response.ResponseMessage;

public class ProductException extends RuntimeException {

    private final ResponseMessage responseMessage;

    public ProductException(ResponseMessage responseMessage) {
        super(responseMessage.getMessage());
        this.responseMessage = responseMessage;
    }

    public String getCode() {
        return responseMessage.getCode();
    }
}
