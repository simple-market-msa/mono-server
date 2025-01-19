package com.isyoudwn.simplemarketmono.order.repository;

import com.isyoudwn.simplemarketmono.member.model.Member;
import com.isyoudwn.simplemarketmono.order.model.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByMember(Member member);
}
