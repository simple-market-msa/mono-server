package com.isyoudwn.simplemarketmono.product.repository;

import com.isyoudwn.simplemarketmono.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
