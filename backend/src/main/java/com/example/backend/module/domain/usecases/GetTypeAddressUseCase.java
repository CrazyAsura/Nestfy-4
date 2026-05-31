package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.TypeAddress;
import com.example.backend.module.domain.ports.in.GetTypeAddressUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypeAddressRepositoryPortOut;

@Component
public class GetTypeAddressUseCase implements GetTypeAddressUseCasePortIn {
    private final ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut;

    public GetTypeAddressUseCase(ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut) {
        this.typeAddressRepositoryPortOut = typeAddressRepositoryPortOut;
    }

    @Override
    public TypeAddress execute(Long id) {
        return typeAddressRepositoryPortOut.findById(id).orElse(null);
    }
}

