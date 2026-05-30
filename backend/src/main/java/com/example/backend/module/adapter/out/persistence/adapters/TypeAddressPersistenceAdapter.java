package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.adapter.out.persistence.repositories.TypeAddressRepository;
import com.example.backend.module.domain.models.TypeAddress;
import com.example.backend.module.domain.ports.out.ITypeAddressRepositoryPortOut;

@Component
public class TypeAddressPersistenceAdapter implements ITypeAddressRepositoryPortOut {

    @Autowired
    private TypeAddressRepository typeAddressRepository;

    @Override
    public TypeAddress save(TypeAddress typeAddress) {
        return typeAddressRepository.save(typeAddress);
    }

    @Override
    public Optional<TypeAddress> findById(Long id) {
        return typeAddressRepository.findById(id);
    }

    @Override
    public Optional<TypeAddress> findByCode(String code) {
        return typeAddressRepository.findByCode(code);
    }

    @Override
    public Iterable<TypeAddress> findAll() {
        return typeAddressRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        typeAddressRepository.deleteById(id);
    }

}
