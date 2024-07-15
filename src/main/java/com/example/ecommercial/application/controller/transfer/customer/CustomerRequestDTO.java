package com.example.ecommercial.application.controller.transfer.customer;

import com.example.ecommercial.application.controller.messages.CustomerMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerRequestDTO {

    @NotBlank(message = CustomerMessage.NOT_BLANK_CUSTOMER_FIRST_NAME)
    private String firstName;

    @NotBlank(message = CustomerMessage.NOT_BLANK_CUSTOMER_LAST_NAME)
    private String lastName;

    @Email(message = CustomerMessage.EMAIL_CUSTOMER_NOT_VALID)
    @NotBlank(message = CustomerMessage.NOT_BLANK_CUSTOMER_EMAIL)
    private String email;

    @NotBlank(message = CustomerMessage.NOT_BLANK_CUSTOMER_PASSWORD)
    @Size(min = 8, max = 255, message = CustomerMessage.PASSWORD_CUSTOMER_NOT_VALID)
    private String password;

    private String phoneNumber;

    private String address;

    private String city;

    private String stateProvince;

    private String country;

    private String postalCode;
}

