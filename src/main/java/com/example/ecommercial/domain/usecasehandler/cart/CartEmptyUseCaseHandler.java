package com.example.ecommercial.domain.usecasehandler.cart;

import com.example.ecommercial.domain.usecase.DefaultValueUseCase;
import com.example.ecommercial.domain.usecasehandler.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartEmptyUseCaseHandler implements VoidUseCaseHandler<DefaultValueUseCase<Long>> {
    @Override
    public void handle(DefaultValueUseCase<Long> useCase) {

    }
}
