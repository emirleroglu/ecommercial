package com.example.ecommercial.domain.usecase;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductUseCase extends UseCase {

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
