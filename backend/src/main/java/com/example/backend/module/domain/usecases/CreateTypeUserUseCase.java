package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.ports.in.CreateTypeUserUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypeUserRepositoryPortOut;

@Component
public class CreateTypeUserUseCase implements CreateTypeUserUseCasePortIn {
    private final ITypeUserRepositoryPortOut typeUserRepositoryPortOut;

    public CreateTypeUserUseCase(ITypeUserRepositoryPortOut typeUserRepositoryPortOut) {
        this.typeUserRepositoryPortOut = typeUserRepositoryPortOut;
    }

    @Override
    public TypeUser execute(TypeUser typeUser) {
        return typeUserRepositoryPortOut.save(typeUser);
    }
}


