package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.ports.in.UpdateAddressUseCasePortIn;
import com.example.backend.module.domain.ports.out.IAddressRepositoryPortOut;

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

