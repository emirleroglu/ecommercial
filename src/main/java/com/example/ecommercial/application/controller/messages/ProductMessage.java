package com.example.ecommercial.application.controller.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMessage {
    public static final String NOT_BLANK_PRODUCT_NAME = "{NotBlank.productRequestDTO.name}";
    public static final String NOT_BLANK_PRODUCT_DESCRIPTION = "{NotBlank.productRequestDTO.description}";
    public static final String NOT_NULL_PRODUCT_PRICE = "{NotNull.productRequestDTO.price}";
    public static final String NOT_NULL_PRODUCT_STOCK = "{NotNull.productRequestDTO.stock}";
    public static final String NOT_BLANK_PRODUCT_CATEGORY = "{NotBlank.productRequestDTO.category}";
    public static final String NOT_BLANK_PRODUCT_IMAGE_URL = "{NotBlank.productRequestDTO.image.url}";
    public static final String NOT_BLANK_PRODUCT_STOCK_UNIT = "{NotBlank.productRequestDTO.stock.unit}";
    public static final String NOT_BLANK_PRODUCT_BRAND = "{NotBlank.productRequestDTO.brand}";
    public static final String INVALID_PRODUCT = "invalid.product";

}
