package com.example.ecommercial.domain.usecase;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerUseCase extends UseCase {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String city;
    private String stateProvince;
    private String country;
    private String postalCode;
}
