package com.example.ecommercial.application.controller.transfer.product;

import com.example.ecommercial.application.controller.messages.ProductMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductRequestDTO {

    @NotBlank(message = ProductMessage.NOT_BLANK_PRODUCT_NAME)
    private String name;
    @NotBlank(message = ProductMessage.NOT_BLANK_PRODUCT_DESCRIPTION)
    private String description;
    @NotNull(message = ProductMessage.NOT_NULL_PRODUCT_PRICE)
    private BigDecimal price;
    @NotNull(message = ProductMessage.NOT_NULL_PRODUCT_STOCK)
    private int stock;
    @NotBlank(message = ProductMessage.NOT_BLANK_PRODUCT_CATEGORY)
    private String category;
    @NotBlank(message = ProductMessage.NOT_BLANK_PRODUCT_IMAGE_URL)
    private String imageUrl;
    @NotBlank(message = ProductMessage.NOT_BLANK_PRODUCT_STOCK_UNIT)
    private String stockUnit;
    @NotBlank(message = ProductMessage.NOT_BLANK_PRODUCT_BRAND)
    private String brand;
}
