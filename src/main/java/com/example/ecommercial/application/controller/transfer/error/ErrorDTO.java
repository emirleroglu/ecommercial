package com.example.ecommercial.application.controller.transfer.error;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorDTO {
    private String code;
    private String message;
}
