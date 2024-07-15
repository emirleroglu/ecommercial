package com.example.ecommercial.application.controller.transfer.cart;

import com.example.ecommercial.application.controller.messages.CartMessage;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CartProductRequestDTO {

    @NotNull(message = CartMessage.NOT_NULL_PRODUCT_ID)
    private Long productId;

    private Long cartId;

    @NotNull(message = CartMessage.NOT_NULL_QUANTITY)
    private Long quantity;

    private Long customerId;
}
