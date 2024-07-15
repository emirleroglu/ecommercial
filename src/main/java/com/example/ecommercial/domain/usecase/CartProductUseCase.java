package com.example.ecommercial.domain.usecase;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartProductUseCase extends UseCase {

    private Long productId;

    private Long cartId;

    private Long quantity;

    private Long customerId;
}
