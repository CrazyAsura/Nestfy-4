package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.TypeAddress;
import com.example.backend.module.domain.ports.in.UpdateTypeAddressUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypeAddressRepositoryPortOut;

public class UpdateTypeAddressUseCase implements UpdateTypeAddressUseCasePortIn {
    private final ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut;

    public UpdateTypeAddressUseCase(ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut) {
        this.typeAddressRepositoryPortOut = typeAddressRepositoryPortOut;
    }

    @Override
    public TypeAddress execute(TypeAddress typeAddress) {
        return typeAddressRepositoryPortOut.save(typeAddress);
    }
}

