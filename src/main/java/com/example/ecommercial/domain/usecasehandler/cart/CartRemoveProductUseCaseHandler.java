package com.example.ecommercial.domain.usecasehandler.cart;

import com.example.ecommercial.domain.aggregate.CartAggregate;
import com.example.ecommercial.domain.usecase.CartProductUseCase;
import com.example.ecommercial.domain.usecasehandler.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartRemoveProductUseCaseHandler extends UseCaseHandler<CartAggregate, CartProductUseCase> {
    @Override
    public CartAggregate handle(CartProductUseCase useCase) {
        return null;
    }
}
