package com.example.ecommercial.infra.adapter;

import com.example.ecommercial.application.controller.exception.BusinessException;
import com.example.ecommercial.application.controller.messages.ProductMessage;
import com.example.ecommercial.domain.aggregate.ProductAggregate;
import com.example.ecommercial.domain.port.ProductPort;
import com.example.ecommercial.infra.entity.Product;
import com.example.ecommercial.infra.mapper.ProductInfraMapper;
import com.example.ecommercial.infra.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;
    private final ProductInfraMapper productInfraMapper;

    @Override
    public ProductAggregate saveProduct(ProductAggregate productAggregate) {
        Product product = productInfraMapper.productAggregateToProduct(productAggregate);
        product = productRepository.save(product);
        return productInfraMapper.productToProductAggregate(product);
    }

    @Override
    public ProductAggregate updateProduct(ProductAggregate productAggregate) {
        Product product = productInfraMapper.productAggregateToProduct(productAggregate);
        product = productRepository.save(product);
        return productInfraMapper.productToProductAggregate(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public ProductAggregate getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new BusinessException(ProductMessage.INVALID_PRODUCT));
        return productInfraMapper.productToProductAggregate(product);
    }
}
