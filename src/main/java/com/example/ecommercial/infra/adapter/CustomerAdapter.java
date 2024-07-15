package com.example.ecommercial.infra.adapter;

import com.example.ecommercial.domain.aggregate.CustomerAggregate;
import com.example.ecommercial.domain.port.CustomerPort;
import com.example.ecommercial.infra.entity.Customer;
import com.example.ecommercial.infra.mapper.CustomerInfraMapper;
import com.example.ecommercial.infra.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerAdapter implements CustomerPort {

    private final CustomerRepository customerRepository;
    private final CustomerInfraMapper customerInfraMapper;

    @Override
    public CustomerAggregate saveCustomer(CustomerAggregate customerAggregate) {
        Customer customer = customerInfraMapper.customerAggregateToCustomer(customerAggregate);
        customer = customerRepository.save(customer);
        return customerInfraMapper.customerToCustomerAggregate(customer);
    }

    @Override
    public CustomerAggregate findCustomerById(Long customerId) {
        return customerInfraMapper.customerToCustomerAggregate(customerRepository.getReferenceById(customerId));
    }
}
