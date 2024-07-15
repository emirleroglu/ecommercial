package com.example.ecommercial.domain.port;

import com.example.ecommercial.domain.aggregate.CartAggregate;
import com.example.ecommercial.domain.aggregate.CustomerAggregate;

import java.math.BigDecimal;

public interface CartPort {

    CartAggregate createCart(CustomerAggregate customerAggregate, BigDecimal totalPrice);

    CartAggregate findCartById(Long cartId);

    CartAggregate addProductToCart(CartAggregate cartAggregate, BigDecimal price);
}
