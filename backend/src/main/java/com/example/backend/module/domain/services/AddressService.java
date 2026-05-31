package com.example.backend.module.domain.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.adapter.out.persistence.adapters.AddressPersistenceAdapter;
import com.example.backend.module.domain.models.Address;

@Service
public class AddressService {

    private final AddressPersistenceAdapter addressPersistenceAdapter;

    @Autowired
    public AddressService(AddressPersistenceAdapter addressPersistenceAdapter) {
        this.addressPersistenceAdapter = addressPersistenceAdapter;
    }

    public Address createAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        return addressPersistenceAdapter.save(address);
    }

    public Address getAddress(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return addressPersistenceAdapter.findById(id).orElse(null);
    }

    public Address updateAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        return addressPersistenceAdapter.save(address);
    }

    public void deleteAddress(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        addressPersistenceAdapter.deleteById(id);
    }

    public List<Address> findByUserId(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        return addressPersistenceAdapter.findByUserId(userId);
    }

    public List<Address> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return addressPersistenceAdapter.findByActive(active);
    }
}
