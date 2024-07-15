package com.example.ecommercial.application.controller.endpoint;

import com.example.ecommercial.application.controller.mapper.CustomerUseCaseMapper;
import com.example.ecommercial.application.controller.transfer.customer.CustomerRequestDTO;
import com.example.ecommercial.application.controller.transfer.customer.CustomerResponseDTO;
import com.example.ecommercial.domain.aggregate.CustomerAggregate;
import com.example.ecommercial.domain.usecase.CustomerUseCase;
import com.example.ecommercial.domain.usecasehandler.CustomerSaveUseCaseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerUseCaseMapper customerUseCaseMapper;
    private final CustomerSaveUseCaseHandler customerSaveUseCaseHandler;

    @PostMapping()
    public ResponseEntity<CustomerResponseDTO> saveCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        CustomerUseCase customerUseCase = customerUseCaseMapper.customerRequestDtoToCustomerSaveUseCase(customerRequestDTO);
        CustomerAggregate customerAggregate = customerSaveUseCaseHandler.handle(customerUseCase);
        return ResponseEntity.ok(customerUseCaseMapper.customerAggregateToCustomerResponseDto(customerAggregate));
    }
}
