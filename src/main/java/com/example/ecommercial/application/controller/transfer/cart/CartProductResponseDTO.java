package com.example.ecommercial.application.controller.transfer.cart;

import com.example.ecommercial.application.controller.transfer.product.ProductResponseDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CartProductResponseDTO {

    private Long quantity;

    private ProductResponseDTO productResponseDTO;
}
