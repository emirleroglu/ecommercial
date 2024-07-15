package com.example.ecommercial.domain.port;

import com.example.ecommercial.domain.aggregate.CustomerAggregate;

public interface CustomerPort {

    CustomerAggregate saveCustomer(CustomerAggregate customerAggregate);

    CustomerAggregate findCustomerById(Long customerId);
}
