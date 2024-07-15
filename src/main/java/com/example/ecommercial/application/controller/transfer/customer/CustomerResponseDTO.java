package com.example.ecommercial.application.controller.transfer.customer;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerResponseDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String address;

    private String city;

    private String stateProvince;

    private String country;

    private String postalCode;
}
