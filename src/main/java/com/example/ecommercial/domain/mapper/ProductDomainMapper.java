package com.example.ecommercial.domain.mapper;

import com.example.ecommercial.domain.aggregate.ProductAggregate;
import com.example.ecommercial.domain.usecase.ProductUseCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDomainMapper {

    ProductAggregate productUseCaseToProductAggregate(ProductUseCase productUseCase);
}
