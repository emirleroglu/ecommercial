package com.example.ecommercial.infra.mapper;

import com.example.ecommercial.domain.aggregate.ProductAggregate;
import com.example.ecommercial.infra.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductInfraMapper {

    Product productAggregateToProduct(ProductAggregate productAggregate);

    ProductAggregate productToProductAggregate(Product product);
}
