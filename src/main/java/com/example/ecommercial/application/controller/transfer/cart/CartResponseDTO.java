package com.example.ecommercial.application.controller.transfer.cart;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
public class CartResponseDTO {

    private BigDecimal totalPrice;

    private List<CartProductResponseDTO> cartProductResponseDTO;

}
