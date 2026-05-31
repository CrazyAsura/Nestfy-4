package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteAddressUseCasePortIn;
import com.example.backend.module.domain.ports.out.IAddressRepositoryPortOut;

@Component
public class DeleteAddressUseCase implements DeleteAddressUseCasePortIn {
    private final IAddressRepositoryPortOut addressRepositoryPortOut;

    public DeleteAddressUseCase(IAddressRepositoryPortOut addressRepositoryPortOut) {
        this.addressRepositoryPortOut = addressRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        addressRepositoryPortOut.deleteById(id);
    }
}

