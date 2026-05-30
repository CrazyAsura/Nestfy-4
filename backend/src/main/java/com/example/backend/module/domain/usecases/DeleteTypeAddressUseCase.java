package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteTypeAddressUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypeAddressRepositoryPortOut;

public class DeleteTypeAddressUseCase implements DeleteTypeAddressUseCasePortIn {
    private final ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut;

    public DeleteTypeAddressUseCase(ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut) {
        this.typeAddressRepositoryPortOut = typeAddressRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        typeAddressRepositoryPortOut.deleteById(id);
    }
}

