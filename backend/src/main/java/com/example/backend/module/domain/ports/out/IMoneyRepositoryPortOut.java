package com.example.backend.module.domain.ports.out;

import java.util.Optional;

import com.example.backend.module.domain.models.Money;

public interface IMoneyRepositoryPortOut extends IRepositoryPortOut<Money, Long> {

    public Optional<Money> findByClientId(Long clientId);
}

