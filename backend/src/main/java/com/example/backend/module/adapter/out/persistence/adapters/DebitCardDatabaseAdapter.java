package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class DebitCardDatabaseAdapter implements IDebitCardRepositoryPortOut {

    @Autowired
    private DebitCardRepository debitCardRepository;

    @Override
    public DebitCard save(DebitCard entity) {
        return debitCardRepository.save(entity);
    }

    @Override
    public Optional<DebitCard> findById(Long id) {
        return debitCardRepository.findById(id);
    }

    @Override
    public Iterable<DebitCard> findAll() {
        return debitCardRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        debitCardRepository.deleteById(id);
    }

    @Override
    public Optional<DebitCard> findByCardNumber(String cardNumber) {
        return debitCardRepository.findByCardNumber(cardNumber).stream().findFirst();
    }

    @Override
    public List<DebitCard> findByActive(Boolean active) {
        return debitCardRepository.findByActive(active);
    }

    @Override
    public List<DebitCard> findByClientId(Long clientId) {
        return new java.util.ArrayList<>();
    }
}
