package com.isyoudwn.simplemarketmono.order.service;

import com.isyoudwn.simplemarketmono.member.model.Member;
import com.isyoudwn.simplemarketmono.member.service.MemberService;
import com.isyoudwn.simplemarketmono.order.dto.OrderDto.MyOrders;
import com.isyoudwn.simplemarketmono.order.dto.OrderDto.OrderProductDto;
import com.isyoudwn.simplemarketmono.order.dto.OrderDto.OrderRequest;
import com.isyoudwn.simplemarketmono.order.repository.OrdersRepository;
import com.isyoudwn.simplemarketmono.order.model.OrderProduct;
import com.isyoudwn.simplemarketmono.order.model.Orders;
import com.isyoudwn.simplemarketmono.product.model.Product;
import com.isyoudwn.simplemarketmono.product.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final ProductService productService;
    private final MemberService memberService;

    @Transactional
    public void orderProduct(List<OrderRequest> orderRequests) {
        Member member = memberService.findById(1L);
        Orders orders = Orders.create(member);

        for (OrderRequest orderRequest : orderRequests) {
            Product product = productService.findById(Long.valueOf(orderRequest.productId()), orderRequest.quantity());
            OrderProduct orderProduct = OrderProduct.createOrder(orderRequest.quantity(), product);
            orders.addOrder(orderProduct);
            product.reduceStock(orderProduct.getQuantity());
        }
        ordersRepository.save(orders);
    }


    public List<MyOrders> myOrders(Long userId) {
        Member member = memberService.findById(userId);
        List<Orders> orders = ordersRepository.findByMember(member);
        List<MyOrders> myOrders = new ArrayList<>();

        for (Orders order : orders) {
            List<OrderProductDto> orderProducts = order.getOrderProductList().stream()
                    .map(orderProduct -> new OrderProductDto(orderProduct.getQuantity(),
                            orderProduct.getProduct().getName()))
                    .toList();

            myOrders.add(new MyOrders(order.getId(), orderProducts));
        }
        return myOrders;
    }
}
