package com.isyoudwn.simplemarketmono.order.model;

import com.isyoudwn.simplemarketmono.product.model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Orders orders;

    private Integer quantity;

    @OneToOne
    private Product product;

    public static OrderProduct createOrder(Integer quantity, Product product) {
        return OrderProduct.builder()
                .quantity(quantity)
                .product(product)
                .build();
    }

    public void addOrders(Orders orders) {
        this.orders = orders;
    }
}
