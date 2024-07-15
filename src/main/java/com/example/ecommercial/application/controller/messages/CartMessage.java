package com.example.ecommercial.application.controller.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartMessage {
    public static final String NOT_NULL_PRODUCT_ID = "{NotNull.cartProductRequestDTO.productId}";
    public static final String NOT_NULL_QUANTITY = "{NotNull.cartProductRequestDTO.quantity}";

}
