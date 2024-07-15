package com.example.ecommercial.domain.usecasehandler.product;

import com.example.ecommercial.domain.aggregate.ProductAggregate;
import com.example.ecommercial.domain.mapper.ProductDomainMapper;
import com.example.ecommercial.domain.port.ProductPort;
import com.example.ecommercial.domain.usecase.ProductUseCase;
import com.example.ecommercial.domain.usecasehandler.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSaveUseCaseHandler extends UseCaseHandler<ProductAggregate, ProductUseCase> {

    private final ProductPort productPort;
    private final ProductDomainMapper productDomainMapper;

    @Override
    public ProductAggregate handle(ProductUseCase productUseCase) {
        return productPort.saveProduct(productDomainMapper.productUseCaseToProductAggregate(productUseCase));
    }
}
