package com.example.ecommercial;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "E COMMERCIAL API DOC",
                version = "1.0"))
public class ECommercialApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommercialApplication.class, args);
    }

}
