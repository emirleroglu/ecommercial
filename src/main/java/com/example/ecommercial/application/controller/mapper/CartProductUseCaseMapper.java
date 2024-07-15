package com.example.ecommercial.application.controller.mapper;

import com.example.ecommercial.application.controller.transfer.cart.CartProductRequestDTO;
import com.example.ecommercial.domain.usecase.CartProductUseCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartProductUseCaseMapper {
    CartProductUseCase cartProductRequestDtoToCartProductUseCase(CartProductRequestDTO cartProductRequestDTO);
}
