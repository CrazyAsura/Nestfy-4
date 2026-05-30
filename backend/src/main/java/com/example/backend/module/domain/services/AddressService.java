package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.ports.out.IAddressRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateAddressUseCase;
import com.example.backend.module.domain.usecases.DeleteAddressUseCase;
import com.example.backend.module.domain.usecases.GetAddressUseCase;
import com.example.backend.module.domain.usecases.UpdateAddressUseCase;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final CreateAddressUseCase createAddressUseCase;
    private final GetAddressUseCase getAddressUseCase;
    private final UpdateAddressUseCase updateAddressUseCase;
    private final DeleteAddressUseCase deleteAddressUseCase;

    public AddressService(IAddressRepositoryPortOut addressRepositoryPortOut) {
        this.createAddressUseCase = new CreateAddressUseCase(addressRepositoryPortOut);
        this.getAddressUseCase = new GetAddressUseCase(addressRepositoryPortOut);
        this.updateAddressUseCase = new UpdateAddressUseCase(addressRepositoryPortOut);
        this.deleteAddressUseCase = new DeleteAddressUseCase(addressRepositoryPortOut);
    }

    public Address createAddress(Address address) {
        return createAddressUseCase.execute(address);
    }

    public Address getAddress(Long id) {
        return getAddressUseCase.execute(id);
    }

    public Address updateAddress(Address address) {
        return updateAddressUseCase.execute(address);
    }

    public void deleteAddress(Long id) {
        deleteAddressUseCase.execute(id);
    }
}
