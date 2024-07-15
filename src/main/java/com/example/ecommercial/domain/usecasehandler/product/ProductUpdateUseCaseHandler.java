package com.example.ecommercial.domain.usecasehandler.product;

import com.example.ecommercial.application.controller.exception.BusinessException;
import com.example.ecommercial.application.controller.messages.ProductMessage;
import com.example.ecommercial.domain.aggregate.ProductAggregate;
import com.example.ecommercial.domain.mapper.ProductDomainMapper;
import com.example.ecommercial.domain.port.ProductPort;
import com.example.ecommercial.domain.usecase.ProductUseCase;
import com.example.ecommercial.domain.usecasehandler.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductUpdateUseCaseHandler extends UseCaseHandler<ProductAggregate, ProductUseCase> {

    private final ProductDomainMapper productDomainMapper;
    private final ProductPort productPort;

    @Override
    public ProductAggregate handle(ProductUseCase productUseCase) {
        validate(productUseCase);
        ProductAggregate productAggregate = productDomainMapper.productUseCaseToProductAggregate(productUseCase);
        return productPort.updateProduct(productAggregate);
    }

    private void validate(ProductUseCase productUseCase) {
        boolean isExist = productPort.existById(productUseCase.getId());
        if (!isExist) {
            throw new BusinessException(ProductMessage.INVALID_PRODUCT);
        }
    }
}
