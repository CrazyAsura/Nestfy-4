package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.ports.in.CreateAddressUseCasePortIn;
import com.example.backend.module.domain.ports.out.IAddressRepositoryPortOut;

@Component
public class CreateAddressUseCase implements CreateAddressUseCasePortIn {
    private final IAddressRepositoryPortOut addressRepositoryPortOut;

    public CreateAddressUseCase(IAddressRepositoryPortOut addressRepositoryPortOut) {
        this.addressRepositoryPortOut = addressRepositoryPortOut;
    }

    @Override
    public Address execute(Address address) {
        return addressRepositoryPortOut.save(address);
    }
}



