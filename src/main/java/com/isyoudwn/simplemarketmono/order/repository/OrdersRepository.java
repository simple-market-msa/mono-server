package com.isyoudwn.simplemarketmono.order.repository;

import com.isyoudwn.simplemarketmono.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
