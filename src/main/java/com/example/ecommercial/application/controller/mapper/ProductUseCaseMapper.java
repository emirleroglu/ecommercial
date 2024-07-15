package com.example.ecommercial.application.controller.mapper;

import com.example.ecommercial.application.controller.transfer.product.ProductRequestDTO;
import com.example.ecommercial.application.controller.transfer.product.ProductResponseDTO;
import com.example.ecommercial.domain.aggregate.ProductAggregate;
import com.example.ecommercial.domain.usecase.ProductUseCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductUseCaseMapper {

    ProductUseCase productRequestDtoToProductUseCase(ProductRequestDTO productRequestDTO);

    ProductResponseDTO productAggregateToProductResponseDTO(ProductAggregate productAggregate);
}
