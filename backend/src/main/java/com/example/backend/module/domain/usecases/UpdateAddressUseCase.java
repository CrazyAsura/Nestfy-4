package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.ports.in.UpdateAddressUseCasePortIn;
import com.example.backend.module.domain.ports.out.IAddressRepositoryPortOut;

@Component
public class UpdateAddressUseCase implements UpdateAddressUseCasePortIn {
    private final IAddressRepositoryPortOut addressRepositoryPortOut;

    public UpdateAddressUseCase(IAddressRepositoryPortOut addressRepositoryPortOut) {
        this.addressRepositoryPortOut = addressRepositoryPortOut;
    }

    @Override
    public Address execute(Address address) {
        return addressRepositoryPortOut.save(address);
    }
}

