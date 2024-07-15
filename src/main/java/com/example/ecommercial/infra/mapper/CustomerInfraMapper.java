package com.example.ecommercial.infra.mapper;

import com.example.ecommercial.domain.aggregate.CustomerAggregate;
import com.example.ecommercial.infra.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerInfraMapper {

    Customer customerAggregateToCustomer(CustomerAggregate customerAggregate);

    CustomerAggregate customerToCustomerAggregate(Customer customer);
}
