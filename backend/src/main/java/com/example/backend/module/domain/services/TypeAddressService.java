package com.example.backend.module.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.adapter.out.persistence.adapters.TypeAddressPersistenceAdapter;
import com.example.backend.module.domain.models.TypeAddress;

@Service
public class TypeAddressService {

    private final TypeAddressPersistenceAdapter typeAddressPersistenceAdapter;

    @Autowired
    public TypeAddressService(TypeAddressPersistenceAdapter typeAddressPersistenceAdapter) {
        this.typeAddressPersistenceAdapter = typeAddressPersistenceAdapter;
    }

    public TypeAddress createTypeAddress(TypeAddress typeAddress) {
        if (typeAddress == null) {
            throw new IllegalArgumentException("TypeAddress cannot be null");
        }
        return typeAddressPersistenceAdapter.save(typeAddress);
    }

    public TypeAddress getTypeAddress(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return typeAddressPersistenceAdapter.findById(id).orElse(null);
    }

    public TypeAddress updateTypeAddress(TypeAddress typeAddress) {
        if (typeAddress == null) {
            throw new IllegalArgumentException("TypeAddress cannot be null");
        }
        return typeAddressPersistenceAdapter.save(typeAddress);
    }

    public void deleteTypeAddress(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        typeAddressPersistenceAdapter.deleteById(id);
    }

    public Optional<TypeAddress> findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("code cannot be null");
        }
        return typeAddressPersistenceAdapter.findByCode(code);
    }
}
