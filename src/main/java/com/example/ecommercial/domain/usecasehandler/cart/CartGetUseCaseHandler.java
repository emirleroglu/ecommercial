package com.example.ecommercial.domain.usecasehandler.cart;

import com.example.ecommercial.domain.aggregate.CartAggregate;
import com.example.ecommercial.domain.port.CartPort;
import com.example.ecommercial.domain.usecase.DefaultValueUseCase;
import com.example.ecommercial.domain.usecasehandler.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartGetUseCaseHandler extends UseCaseHandler<CartAggregate, DefaultValueUseCase<Long>> {

    private final CartPort cartPort;

    @Override
    public CartAggregate handle(DefaultValueUseCase<Long> useCase) {
        return cartPort.findCartById(useCase.getValue());
    }
}
