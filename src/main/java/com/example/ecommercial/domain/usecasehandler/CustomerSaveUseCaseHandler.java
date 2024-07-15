package com.example.ecommercial.domain.usecasehandler;

import com.example.ecommercial.domain.aggregate.CustomerAggregate;
import com.example.ecommercial.domain.mapper.CustomerDomainMapper;
import com.example.ecommercial.domain.port.CustomerPort;
import com.example.ecommercial.domain.usecase.CustomerUseCase;
import com.example.ecommercial.domain.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerSaveUseCaseHandler extends UseCaseHandler<CustomerAggregate, CustomerUseCase> {

    private final CustomerDomainMapper customerDomainMapper;
    private final CustomerPort customerPort;

    @Override
    public CustomerAggregate handle(CustomerUseCase useCase) {
        String hashPassword = HashUtil.hashPassword(useCase.getPassword());
        CustomerAggregate customerAggregate = customerDomainMapper.customerSaveUseCaseToCustomerAggregate(useCase);
        customerAggregate.setPassword(hashPassword);
        return customerPort.saveCustomer(customerAggregate);
    }
}
