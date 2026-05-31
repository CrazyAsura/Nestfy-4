package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.ports.out.IAddressRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateAddressUseCase;
import com.example.backend.module.domain.usecases.DeleteAddressUseCase;
import com.example.backend.module.domain.usecases.GetAddressUseCase;
import com.example.backend.module.domain.usecases.UpdateAddressUseCase;

@Component
public class AddressPersistenceAdapter {

    private final CreateAddressUseCase createAddressUseCase;
    private final GetAddressUseCase getAddressUseCase;
    private final UpdateAddressUseCase updateAddressUseCase;
    private final DeleteAddressUseCase deleteAddressUseCase;
    private final IAddressRepositoryPortOut addressRepositoryPortOut;

    @Autowired
    public AddressPersistenceAdapter(CreateAddressUseCase createAddressUseCase,
            GetAddressUseCase getAddressUseCase,
            UpdateAddressUseCase updateAddressUseCase,
            DeleteAddressUseCase deleteAddressUseCase,
            IAddressRepositoryPortOut addressRepositoryPortOut) {
        this.createAddressUseCase = createAddressUseCase;
        this.getAddressUseCase = getAddressUseCase;
        this.updateAddressUseCase = updateAddressUseCase;
        this.deleteAddressUseCase = deleteAddressUseCase;
        this.addressRepositoryPortOut = addressRepositoryPortOut;
    }

    public Optional<Address> findById(Long id) {
        return Optional.ofNullable(getAddressUseCase.execute(id));
    }

    public Iterable<Address> findAll() {
        return addressRepositoryPortOut.findAll();
    }

    public Address save(Address entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createAddressUseCase.execute(entity);
        } else {
            return updateAddressUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteAddressUseCase.execute(id);
    }

    public List<Address> findByUserId(Long userId) {
        return addressRepositoryPortOut.findByUserId(userId);
    }

    public List<Address> findByActive(Boolean active) {
        return addressRepositoryPortOut.findByActive(active);
    }
}
