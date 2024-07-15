package com.example.ecommercial.infra.mapper;

import com.example.ecommercial.domain.aggregate.CartAggregate;
import com.example.ecommercial.domain.aggregate.CartProductAggregate;
import com.example.ecommercial.infra.entity.Cart;
import com.example.ecommercial.infra.entity.CartProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartInfraMapper {

    @Mapping(target = "cartProductAggregate", source = "cart.cartProducts")
    CartAggregate cartToCartAggregate(Cart cart);

    @Mapping(target = "quantity", source = "cartProductAggregate.quantity")
    @Mapping(target = "product", source = "cartProductAggregate.productAggregate")
    CartProduct cartProductAggregateToCartProduct(CartProductAggregate cartProductAggregate);

    @Mapping(target = "cart", source = "cartAggregate")
    CartProduct cartAggregateToCartProduct(CartAggregate cartAggregate);

}
