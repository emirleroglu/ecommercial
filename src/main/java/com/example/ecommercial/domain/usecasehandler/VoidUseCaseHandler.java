package com.example.ecommercial.domain.usecasehandler;

import com.example.ecommercial.domain.usecase.UseCase;

public interface VoidUseCaseHandler<U extends UseCase> {
    void handle(U useCase);
}
