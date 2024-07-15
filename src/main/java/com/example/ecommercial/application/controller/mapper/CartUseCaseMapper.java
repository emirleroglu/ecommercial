package com.example.ecommercial.application.controller.mapper;

import com.example.ecommercial.application.controller.transfer.cart.CartResponseDTO;
import com.example.ecommercial.domain.aggregate.CartAggregate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartUseCaseMapper {

    CartResponseDTO cartAggregateToCartResponseDTO(CartAggregate cartAggregate);
}
