package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteTypeUserUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypeUserRepositoryPortOut;

public class DeleteTypeUserUseCase implements DeleteTypeUserUseCasePortIn {
    private final ITypeUserRepositoryPortOut typeUserRepositoryPortOut;

    public DeleteTypeUserUseCase(ITypeUserRepositoryPortOut typeUserRepositoryPortOut) {
        this.typeUserRepositoryPortOut = typeUserRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        typeUserRepositoryPortOut.deleteById(id);
    }
}

