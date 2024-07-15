package com.example.ecommercial.infra.adapter;

import com.example.ecommercial.domain.aggregate.CartAggregate;
import com.example.ecommercial.domain.aggregate.CustomerAggregate;
import com.example.ecommercial.domain.port.CartPort;
import com.example.ecommercial.infra.entity.Cart;
import com.example.ecommercial.infra.entity.CartProduct;
import com.example.ecommercial.infra.mapper.CartInfraMapper;
import com.example.ecommercial.infra.mapper.CustomerInfraMapper;
import com.example.ecommercial.infra.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CartAdapter implements CartPort {

    private final CustomerInfraMapper customerInfraMapper;
    private final CartRepository cartRepository;
    private final CartInfraMapper cartInfraMapper;

    @Override
    public CartAggregate createCart(CustomerAggregate customerAggregate, BigDecimal totalPrice) {
        Cart cart = Cart.builder()
                .totalPrice(totalPrice)
                .customer(customerInfraMapper.customerAggregateToCustomer(customerAggregate))
                .build();
        cart = cartRepository.save(cart);

        return cartInfraMapper.cartToCartAggregate(cart);
    }

    @Override
    public CartAggregate findCartById(Long cartId) {/*
        Cart cart = cartRepository.findById(cartId).orElse(null);
        CartAggregate cartAggregate = cartInfraMapper.cartToCartAggregate(cart);
        cart.getCartProducts()
        */
        return null;
    }

    @Override
    @Transactional
    public CartAggregate addProductToCart(CartAggregate cartAggregate, BigDecimal price) {
        CartProduct cartProduct = cartInfraMapper.cartAggregateToCartProduct(cartAggregate);

        Cart cart = cartRepository.findById(cartAggregate.getId()).orElseThrow(() -> new RuntimeException("Cart not found"));

        Set<CartProduct> productSet = cart.getCartProducts();
        if (productSet == null) {
            productSet = new HashSet<>();
        }

        cartProduct.setCart(cart);
        productSet.add(cartProduct);

        cart.setTotalPrice(cart.getTotalPrice().add(price));
        cart.setCartProducts(productSet);

        cartRepository.save(cart);

        return cartInfraMapper.cartToCartAggregate(cart);
    }


}
