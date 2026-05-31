package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.TypeAddress;
import com.example.backend.module.domain.ports.in.CreateTypeAddressUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypeAddressRepositoryPortOut;

@Component
public class CreateTypeAddressUseCase implements CreateTypeAddressUseCasePortIn {
    private final ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut;

    public CreateTypeAddressUseCase(ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut) {
        this.typeAddressRepositoryPortOut = typeAddressRepositoryPortOut;
    }

    @Override
    public TypeAddress execute(TypeAddress typeAddress) {
        return typeAddressRepositoryPortOut.save(typeAddress);
    }
}



