package com.example.backend.module.domain.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.MoneyPersistenceAdapter;

@Service
public class MoneyService {

    private final MoneyPersistenceAdapter moneyPersistenceAdapter;

    @Autowired
    public MoneyService(MoneyPersistenceAdapter moneyPersistenceAdapter) {
        this.moneyPersistenceAdapter = moneyPersistenceAdapter;
    }

    public Money createMoney(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Money cannot be null");
        }
        return moneyPersistenceAdapter.save(money);
    }

    public Money getMoney(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return moneyPersistenceAdapter.findById(id).orElse(null);
    }

    public Money updateMoney(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Money cannot be null");
        }
        return moneyPersistenceAdapter.save(money);
    }

    public void deleteMoney(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        moneyPersistenceAdapter.deleteById(id);
    }
    public Optional<Money> findByClientId(Long clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("clientId cannot be null");
        }
        return moneyPersistenceAdapter.findByClientId(clientId);
    }
}
