package com.example.ecommercial.domain.usecasehandler.product;

import com.example.ecommercial.domain.port.ProductPort;
import com.example.ecommercial.domain.usecase.DefaultValueUseCase;
import com.example.ecommercial.domain.usecasehandler.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDeleteUseCaseHandler implements VoidUseCaseHandler<DefaultValueUseCase<Long>> {

    private final ProductPort productPort;

    @Override
    public void handle(DefaultValueUseCase<Long> useCase) {
        productPort.deleteProductById(useCase.getValue());
    }
}
