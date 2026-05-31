package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class MoneyDatabaseAdapter implements IMoneyRepositoryPortOut {

    @Autowired
    private MoneyRepository moneyRepository;

    @Override
    public Money save(Money entity) {
        return moneyRepository.save(entity);
    }

    @Override
    public Optional<Money> findById(Long id) {
        return moneyRepository.findById(id);
    }

    @Override
    public Iterable<Money> findAll() {
        return moneyRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        moneyRepository.deleteById(id);
    }

    @Override
    public Optional<Money> findByClientId(Long clientId) {
        return Optional.empty();
    }
}
