package com.example.backend.module.domain.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.CreditCardPersistenceAdapter;

@Service
public class CreditCardService {

    private final CreditCardPersistenceAdapter creditCardPersistenceAdapter;

    @Autowired
    public CreditCardService(CreditCardPersistenceAdapter creditCardPersistenceAdapter) {
        this.creditCardPersistenceAdapter = creditCardPersistenceAdapter;
    }

    public CreditCard createCreditCard(CreditCard creditCard) {
        if (creditCard == null) {
            throw new IllegalArgumentException("CreditCard cannot be null");
        }
        return creditCardPersistenceAdapter.save(creditCard);
    }

    public CreditCard getCreditCard(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return creditCardPersistenceAdapter.findById(id).orElse(null);
    }

    public CreditCard updateCreditCard(CreditCard creditCard) {
        if (creditCard == null) {
            throw new IllegalArgumentException("CreditCard cannot be null");
        }
        return creditCardPersistenceAdapter.save(creditCard);
    }

    public void deleteCreditCard(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        creditCardPersistenceAdapter.deleteById(id);
    }
    public Optional<CreditCard> findByCardNumber(String cardNumber) {
        if (cardNumber == null) {
            throw new IllegalArgumentException("cardNumber cannot be null");
        }
        return creditCardPersistenceAdapter.findByCardNumber(cardNumber);
    }

    public List<CreditCard> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return creditCardPersistenceAdapter.findByActive(active);
    }
}
