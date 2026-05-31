package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.ports.in.GetTypeUserUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypeUserRepositoryPortOut;

@Component
public class GetTypeUserUseCase implements GetTypeUserUseCasePortIn {
    private final ITypeUserRepositoryPortOut iTypeUserRepositoryPortOut;

    public GetTypeUserUseCase(ITypeUserRepositoryPortOut iTypeUserRepositoryPortOut) {
        this.iTypeUserRepositoryPortOut = iTypeUserRepositoryPortOut;
    }

    @Override
    public TypeUser execute(Long id) {
        return iTypeUserRepositoryPortOut.findById(id).orElse(null);
    }
}

