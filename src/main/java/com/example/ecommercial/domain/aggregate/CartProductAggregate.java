package com.example.ecommercial.domain.aggregate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartProductAggregate {

    private Long quantity;

    private ProductAggregate productAggregate;
}
