package com.example.ecommercial.domain.mapper;

import com.example.ecommercial.domain.aggregate.CartAggregate;
import com.example.ecommercial.domain.aggregate.CartProductAggregate;
import com.example.ecommercial.domain.aggregate.CustomerAggregate;
import com.example.ecommercial.domain.aggregate.ProductAggregate;
import com.example.ecommercial.domain.usecase.CartProductUseCase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartDomainMapper {

    @Mapping(source = "customerAggregate", target = "customerAggregate")
    @Mapping(source = "cartProductAggregate", target = "cartProductAggregate")
    @Mapping(source = "cartProductUseCase.cartId", target = "id")
    CartAggregate customerAggregateAndCartProductAggregateToCartAggregate(CustomerAggregate customerAggregate, CartProductAggregate cartProductAggregate, CartProductUseCase cartProductUseCase);

    @Mapping(source = "productAggregate", target = "productAggregate")
    @Mapping(source = "cartProductUseCase.quantity", target = "quantity")
    CartProductAggregate cartProductUseCaseToCartProductAggregate(CartProductUseCase cartProductUseCase, ProductAggregate productAggregate);
}
