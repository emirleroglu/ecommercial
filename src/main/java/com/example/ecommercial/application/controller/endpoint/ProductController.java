package com.example.ecommercial.application.controller.endpoint;

import com.example.ecommercial.application.controller.mapper.ProductUseCaseMapper;
import com.example.ecommercial.application.controller.transfer.product.ProductRequestDTO;
import com.example.ecommercial.application.controller.transfer.product.ProductResponseDTO;
import com.example.ecommercial.domain.aggregate.ProductAggregate;
import com.example.ecommercial.domain.usecase.DefaultValueUseCase;
import com.example.ecommercial.domain.usecase.ProductUseCase;
import com.example.ecommercial.domain.usecasehandler.product.ProductDeleteUseCaseHandler;
import com.example.ecommercial.domain.usecasehandler.product.ProductGetUseCaseHandler;
import com.example.ecommercial.domain.usecasehandler.product.ProductSaveUseCaseHandler;
import com.example.ecommercial.domain.usecasehandler.product.ProductUpdateUseCaseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCaseMapper productUseCaseMapper;
    private final ProductSaveUseCaseHandler productSaveUseCaseHandler;
    private final ProductUpdateUseCaseHandler productUpdateUseCaseHandler;
    private final ProductDeleteUseCaseHandler productDeleteUseCaseHandler;
    private final ProductGetUseCaseHandler productGetUseCaseHandler;

    @PostMapping()
    ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        ProductUseCase productUseCase = productUseCaseMapper.productRequestDtoToProductUseCase(productRequestDTO);
        ProductAggregate productAggregate = productSaveUseCaseHandler.handle(productUseCase);
        return ResponseEntity.ok(productUseCaseMapper.productAggregateToProductResponseDTO(productAggregate));
    }

    @PutMapping("/{id}")
    ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO, @PathVariable Long id) {
        ProductUseCase productUseCase = productUseCaseMapper.productRequestDtoToProductUseCase(productRequestDTO);
        productUseCase.setId(id);
        ProductAggregate productAggregate = productUpdateUseCaseHandler.handle(productUseCase);
        return ResponseEntity.ok(productUseCaseMapper.productAggregateToProductResponseDTO(productAggregate));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productDeleteUseCaseHandler.handle(new DefaultValueUseCase<>(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id) {
        ProductAggregate productAggregate = productGetUseCaseHandler.handle(new DefaultValueUseCase<>(id));
        return ResponseEntity.ok(productUseCaseMapper.productAggregateToProductResponseDTO(productAggregate));
    }
}
