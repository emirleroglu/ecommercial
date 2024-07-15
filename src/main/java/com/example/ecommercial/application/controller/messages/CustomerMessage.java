package com.example.ecommercial.application.controller.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerMessage {

    public static final String NOT_BLANK_CUSTOMER_FIRST_NAME = "{NotBlank.customerRequestDTO.firstName}";

    public static final String NOT_BLANK_CUSTOMER_LAST_NAME = "{NotBlank.customerRequestDTO.lastName}";

    public static final String EMAIL_CUSTOMER_NOT_VALID = "{Email.customerRequestDTO.email}";

    public static final String NOT_BLANK_CUSTOMER_EMAIL = "{NotBlank.customerRequestDTO.email}";

    public static final String NOT_BLANK_CUSTOMER_PASSWORD = "{NotBlank.customerRequestDTO.password}";

    public static final String PASSWORD_CUSTOMER_NOT_VALID = "{Size.customerRequestDTO.password}";

    public static final String INVALID_CUSTOMER = "invalid.customer";

}
