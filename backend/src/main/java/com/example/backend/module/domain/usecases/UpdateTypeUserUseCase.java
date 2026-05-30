package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.ports.in.UpdateTypeUserUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypeUserRepositoryPortOut;

public class UpdateTypeUserUseCase implements UpdateTypeUserUseCasePortIn {
    private final ITypeUserRepositoryPortOut typeUserRepositoryPortOut;

    public UpdateTypeUserUseCase(ITypeUserRepositoryPortOut typeUserRepositoryPortOut) {
        this.typeUserRepositoryPortOut = typeUserRepositoryPortOut;
    }

    @Override
    public TypeUser execute(TypeUser typeUser) {
        return typeUserRepositoryPortOut.save(typeUser);
    }
}

