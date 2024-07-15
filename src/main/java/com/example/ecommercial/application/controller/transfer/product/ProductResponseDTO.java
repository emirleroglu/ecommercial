package com.example.ecommercial.application.controller.transfer.product;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductResponseDTO {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private int stock;

    private String category;

    private String imageUrl;

    private String stockUnit;

    private String brand;
}
