package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class CreditCardDatabaseAdapter implements ICreditCardRepositoryPortOut {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCard save(CreditCard entity) {
        return creditCardRepository.save(entity);
    }

    @Override
    public Optional<CreditCard> findById(Long id) {
        return creditCardRepository.findById(id);
    }

    @Override
    public Iterable<CreditCard> findAll() {
        return creditCardRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        creditCardRepository.deleteById(id);
    }

    @Override
    public Optional<CreditCard> findByCardNumber(String cardNumber) {
        return creditCardRepository.findByCardNumber(cardNumber).stream().findFirst();
    }

    @Override
    public List<CreditCard> findByActive(Boolean active) {
        return creditCardRepository.findByActive(active);
    }
}
