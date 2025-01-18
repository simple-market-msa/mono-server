package com.isyoudwn.simplemarketmono.common.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResponseMessage {

    ;
    private final String code;
    private final String message;
}
