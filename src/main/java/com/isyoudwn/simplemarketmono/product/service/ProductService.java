package com.isyoudwn.simplemarketmono.product.service;

import static com.isyoudwn.simplemarketmono.common.response.ResponseMessage.*;

import com.isyoudwn.simplemarketmono.common.response.ResponseMessage;
import com.isyoudwn.simplemarketmono.product.exception.ProductException;
import com.isyoudwn.simplemarketmono.product.model.Product;
import com.isyoudwn.simplemarketmono.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findById(Long productId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(PRODUCT_NOT_FOUND));

        if (product.getStock() < quantity) {
            throw new ProductException(PRODUCT_STOCK_NOT_ENOUGH);
        }
        return product;
    }


}
