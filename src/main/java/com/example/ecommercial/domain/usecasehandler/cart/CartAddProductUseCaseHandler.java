package com.example.ecommercial.domain.usecasehandler.cart;

import com.example.ecommercial.application.controller.exception.BusinessException;
import com.example.ecommercial.application.controller.messages.CustomerMessage;
import com.example.ecommercial.domain.aggregate.CartAggregate;
import com.example.ecommercial.domain.aggregate.CartProductAggregate;
import com.example.ecommercial.domain.aggregate.CustomerAggregate;
import com.example.ecommercial.domain.aggregate.ProductAggregate;
import com.example.ecommercial.domain.mapper.CartDomainMapper;
import com.example.ecommercial.domain.port.CartPort;
import com.example.ecommercial.domain.port.CustomerPort;
import com.example.ecommercial.domain.port.ProductPort;
import com.example.ecommercial.domain.usecase.CartProductUseCase;
import com.example.ecommercial.domain.usecasehandler.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CartAddProductUseCaseHandler extends UseCaseHandler<CartAggregate, CartProductUseCase> {


    private final CartPort cartPort;
    private final CustomerPort customerPort;
    private final ProductPort productPort;
    private final CartDomainMapper cartDomainMapper;

    @Override
    public CartAggregate handle(CartProductUseCase cartProductUseCase) {
        CustomerAggregate customerAggregate = validateCustomer(cartProductUseCase);
        ProductAggregate productAggregate = productPort.getProductById(cartProductUseCase.getProductId());

        CartProductAggregate cartProductAggregate = cartDomainMapper.cartProductUseCaseToCartProductAggregate(cartProductUseCase, productAggregate);
        CartAggregate cartAggregate = cartDomainMapper.customerAggregateAndCartProductAggregateToCartAggregate(customerAggregate, cartProductAggregate, cartProductUseCase);

        BigDecimal productPrice = calculateProductPrice(productAggregate, cartProductUseCase);

        if (cartAggregate.getId() == null) {
            CartAggregate cartAggregateDB = cartPort.createCart(customerAggregate, BigDecimal.valueOf(0D));
            cartAggregate.setId(cartAggregateDB.getId());
        }
        return cartPort.addProductToCart(cartAggregate, productPrice);
    }

    private BigDecimal calculateProductPrice(ProductAggregate productAggregate, CartProductUseCase cartProductUseCase) {
        return productAggregate.getPrice().multiply(BigDecimal.valueOf(cartProductUseCase.getQuantity()));
    }

    private CustomerAggregate validateCustomer(CartProductUseCase cartProductUseCase) {
        if (cartProductUseCase.getCustomerId() == null) {
            throw new BusinessException(CustomerMessage.INVALID_CUSTOMER);
        }

        CustomerAggregate isExistCustomerAggregate = customerPort.findCustomerById(cartProductUseCase.getCustomerId());

        if (isExistCustomerAggregate == null) {
            throw new BusinessException(CustomerMessage.INVALID_CUSTOMER);
        }

        return isExistCustomerAggregate;
    }
}
