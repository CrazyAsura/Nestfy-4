package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class MoneyPersistenceAdapter {

    private final CreateMoneyUseCase createMoneyUseCase;
    private final GetMoneyUseCase getMoneyUseCase;
    private final UpdateMoneyUseCase updateMoneyUseCase;
    private final DeleteMoneyUseCase deleteMoneyUseCase;
    private final IMoneyRepositoryPortOut moneyRepositoryPortOut;

    @Autowired
    public MoneyPersistenceAdapter(CreateMoneyUseCase createMoneyUseCase,
            GetMoneyUseCase getMoneyUseCase,
            UpdateMoneyUseCase updateMoneyUseCase,
            DeleteMoneyUseCase deleteMoneyUseCase,
            IMoneyRepositoryPortOut moneyRepositoryPortOut) {
        this.createMoneyUseCase = createMoneyUseCase;
        this.getMoneyUseCase = getMoneyUseCase;
        this.updateMoneyUseCase = updateMoneyUseCase;
        this.deleteMoneyUseCase = deleteMoneyUseCase;
        this.moneyRepositoryPortOut = moneyRepositoryPortOut;
    }

    public Optional<Money> findById(Long id) {
        return Optional.ofNullable(getMoneyUseCase.execute(id));
    }

    public Iterable<Money> findAll() {
        return moneyRepositoryPortOut.findAll();
    }

    public Money save(Money entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createMoneyUseCase.execute(entity);
        } else {
            return updateMoneyUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteMoneyUseCase.execute(id);
    }
    public Optional<Money> findByClientId(Long clientId) {
        return moneyRepositoryPortOut.findByClientId(clientId);
    }
}
