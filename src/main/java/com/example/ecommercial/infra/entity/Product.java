package com.example.ecommercial.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product extends BasePojo {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "stock_unit", nullable = false)
    private String stockUnit;

    @Column(name = "brand", nullable = false)
    private String brand;
}
