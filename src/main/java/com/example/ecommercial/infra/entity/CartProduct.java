package com.example.ecommercial.infra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Cart_Products")
public class CartProduct extends BasePojo {

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Product product;

    private int quantity;
}
