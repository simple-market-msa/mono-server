package com.isyoudwn.simplemarketmono.common.handler;

import com.isyoudwn.simplemarketmono.common.response.Response;
import com.isyoudwn.simplemarketmono.order.OrderExcepction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderExcepction.class)
    public ResponseEntity<Response<String>> handleMemberException(OrderExcepction ex) {
        return ResponseEntity
                .badRequest()
                .body(Response.failure(ex.getCode(), ex.getMessage()));
    }
}
