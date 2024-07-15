package com.example.ecommercial.domain.usecasehandler;

import com.example.ecommercial.domain.usecase.UseCase;

public abstract class UseCaseHandler<A, U extends UseCase> {
    public abstract A handle(U useCase);
}
