package com.example.ecommercial.application.controller.endpoint;

import com.example.ecommercial.application.controller.mapper.CartProductUseCaseMapper;
import com.example.ecommercial.application.controller.mapper.CartUseCaseMapper;
import com.example.ecommercial.application.controller.transfer.cart.CartProductRequestDTO;
import com.example.ecommercial.application.controller.transfer.cart.CartResponseDTO;
import com.example.ecommercial.domain.aggregate.CartAggregate;
import com.example.ecommercial.domain.usecase.CartProductUseCase;
import com.example.ecommercial.domain.usecase.DefaultValueUseCase;
import com.example.ecommercial.domain.usecasehandler.cart.CartAddProductUseCaseHandler;
import com.example.ecommercial.domain.usecasehandler.cart.CartEmptyUseCaseHandler;
import com.example.ecommercial.domain.usecasehandler.cart.CartGetUseCaseHandler;
import com.example.ecommercial.domain.usecasehandler.cart.CartRemoveProductUseCaseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartGetUseCaseHandler cartGetUseCaseHandler;
    private final CartEmptyUseCaseHandler cartEmptyUseCaseHandler;
    private final CartUseCaseMapper cartUseCaseMapper;
    private final CartProductUseCaseMapper cartProductUseCaseMapper;
    private final CartAddProductUseCaseHandler cartAddProductUseCaseHandler;
    private final CartRemoveProductUseCaseHandler cartRemoveProductUseCaseHandler;

    @GetMapping("/{id}")
    ResponseEntity<CartResponseDTO> getCartById(@PathVariable Long id) {
        CartAggregate cartAggregate = cartGetUseCaseHandler.handle(new DefaultValueUseCase<>(id));
        return ResponseEntity.ok(cartUseCaseMapper.cartAggregateToCartResponseDTO(cartAggregate));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> emptyCartById(@PathVariable Long id) {
        cartEmptyUseCaseHandler.handle(new DefaultValueUseCase<>(id));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-product")
    ResponseEntity<CartResponseDTO> addProductToChart(@RequestBody @Valid CartProductRequestDTO cartProductRequestDTO) {
        CartProductUseCase cartProductUseCase = cartProductUseCaseMapper.cartProductRequestDtoToCartProductUseCase(cartProductRequestDTO);
        CartAggregate cartAggregate = cartAddProductUseCaseHandler.handle(cartProductUseCase);
        return ResponseEntity.ok(cartUseCaseMapper.cartAggregateToCartResponseDTO(cartAggregate));
    }

    @PostMapping("/remove-product")
    ResponseEntity<CartResponseDTO> removeProductToChart(@RequestBody @Valid CartProductRequestDTO cartProductRequestDTO) {
        CartProductUseCase cartProductUseCase = cartProductUseCaseMapper.cartProductRequestDtoToCartProductUseCase(cartProductRequestDTO);
        CartAggregate cartAggregate = cartRemoveProductUseCaseHandler.handle(cartProductUseCase);
        return ResponseEntity.ok(cartUseCaseMapper.cartAggregateToCartResponseDTO(cartAggregate));
    }
}
