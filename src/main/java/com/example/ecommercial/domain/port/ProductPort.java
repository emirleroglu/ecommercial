package com.example.ecommercial.domain.port;

import com.example.ecommercial.domain.aggregate.ProductAggregate;

public interface ProductPort {

    ProductAggregate saveProduct(ProductAggregate productAggregate);

    ProductAggregate updateProduct(ProductAggregate productAggregate);

    void deleteProductById(Long id);

    boolean existById(Long id);

    ProductAggregate getProductById(Long id);
}
