package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.ports.in.GetAddressUseCasePortIn;
import com.example.backend.module.domain.ports.out.IAddressRepositoryPortOut;

@Component
public class GetAddressUseCase implements GetAddressUseCasePortIn {
    private final IAddressRepositoryPortOut addressRepositoryPortOut;

    public GetAddressUseCase(IAddressRepositoryPortOut addressRepositoryPortOut) {
        this.addressRepositoryPortOut = addressRepositoryPortOut;
    }

    @Override
    public Address execute(Long id) {
        return addressRepositoryPortOut.findById(id).orElse(null);
    }
}



