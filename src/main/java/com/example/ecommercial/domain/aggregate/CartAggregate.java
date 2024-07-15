package com.example.ecommercial.domain.aggregate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class CartAggregate {

    private Long id;

    private BigDecimal totalPrice;

    private CustomerAggregate customerAggregate;

    private List<CartProductAggregate> cartProductAggregate;
}
