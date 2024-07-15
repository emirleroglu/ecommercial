package com.example.ecommercial.domain.mapper;

import com.example.ecommercial.domain.aggregate.CustomerAggregate;
import com.example.ecommercial.domain.usecase.CustomerUseCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDomainMapper {

    CustomerAggregate customerSaveUseCaseToCustomerAggregate(CustomerUseCase customerUseCase);
}
