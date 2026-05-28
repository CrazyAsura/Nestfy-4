package com.example.backend.module.domain.ports.out;

import java.util.Optional;

import com.example.backend.module.domain.models.TypeAddress;

public interface TypeAddressRepositoryPortOut extends IRepositoryPortOut<TypeAddress, Long> {

    public Optional<TypeAddress> findByCode(String code);

}
