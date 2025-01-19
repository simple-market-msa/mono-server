package com.isyoudwn.simplemarketmono.order.controller;

import static com.isyoudwn.simplemarketmono.common.response.ResponseMessage.ORDER_SUCCESS;
import static com.isyoudwn.simplemarketmono.common.response.ResponseMessage.READ_MY_ORDER_SUCCESS;

import com.isyoudwn.simplemarketmono.common.response.Response;
import com.isyoudwn.simplemarketmono.order.dto.OrderDto.MyOrders;
import com.isyoudwn.simplemarketmono.order.dto.OrderDto.OrderRequest;
import com.isyoudwn.simplemarketmono.order.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    // 상품 주문
    @PostMapping()
    public ResponseEntity<Response<String>> createOrder(@RequestBody List<OrderRequest> orderRequest) {

        orderService.orderProduct(orderRequest);

        return ResponseEntity
                .ok()
                .body(Response.success(
                        ORDER_SUCCESS.getCode(),
                        ORDER_SUCCESS.getMessage()
                ));
    }

    // 나의 주문 리스트 조회
    @GetMapping("/my-order")
    public ResponseEntity<Response<List<MyOrders>>> readMyOrders() {
        List<MyOrders> myOrders = orderService.myOrders(1L);

        return ResponseEntity
                .ok()
                .body(Response.success(
                        READ_MY_ORDER_SUCCESS.getCode(),
                        READ_MY_ORDER_SUCCESS.getMessage(),
                        myOrders
                ));

    }
}
