package com.example.ecommercial.domain.usecasehandler.product;

import com.example.ecommercial.domain.aggregate.ProductAggregate;
import com.example.ecommercial.domain.port.ProductPort;
import com.example.ecommercial.domain.usecase.DefaultValueUseCase;
import com.example.ecommercial.domain.usecasehandler.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductGetUseCaseHandler extends UseCaseHandler<ProductAggregate, DefaultValueUseCase<Long>> {

    private final ProductPort productPort;

    @Override
    public ProductAggregate handle(DefaultValueUseCase<Long> useCase) {
        return productPort.getProductById(useCase.getValue());
    }
}
