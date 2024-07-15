package com.example.ecommercial.application.controller.mapper;

import com.example.ecommercial.application.controller.transfer.customer.CustomerRequestDTO;
import com.example.ecommercial.application.controller.transfer.customer.CustomerResponseDTO;
import com.example.ecommercial.domain.aggregate.CustomerAggregate;
import com.example.ecommercial.domain.usecase.CustomerUseCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerUseCaseMapper {

    CustomerUseCase customerRequestDtoToCustomerSaveUseCase(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO customerAggregateToCustomerResponseDto(CustomerAggregate customerAggregate);
}
