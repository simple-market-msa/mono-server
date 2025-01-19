package com.isyoudwn.simplemarketmono.member.exception;

import com.isyoudwn.simplemarketmono.common.response.ResponseMessage;

public class MemberException extends RuntimeException {

    private final ResponseMessage responseMessage;

    public MemberException(ResponseMessage responseMessage) {
        super(responseMessage.getMessage());
        this.responseMessage = responseMessage;
    }

    public String getCode() {
        return responseMessage.getCode();
    }
}