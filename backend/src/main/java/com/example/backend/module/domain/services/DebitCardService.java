package com.example.backend.module.domain.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.DebitCardPersistenceAdapter;

@Service
public class DebitCardService {

    private final DebitCardPersistenceAdapter debitCardPersistenceAdapter;

    @Autowired
    public DebitCardService(DebitCardPersistenceAdapter debitCardPersistenceAdapter) {
        this.debitCardPersistenceAdapter = debitCardPersistenceAdapter;
    }

    public DebitCard createDebitCard(DebitCard debitCard) {
        if (debitCard == null) {
            throw new IllegalArgumentException("DebitCard cannot be null");
        }
        return debitCardPersistenceAdapter.save(debitCard);
    }

    public DebitCard getDebitCard(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return debitCardPersistenceAdapter.findById(id).orElse(null);
    }

    public DebitCard updateDebitCard(DebitCard debitCard) {
        if (debitCard == null) {
            throw new IllegalArgumentException("DebitCard cannot be null");
        }
        return debitCardPersistenceAdapter.save(debitCard);
    }

    public void deleteDebitCard(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        debitCardPersistenceAdapter.deleteById(id);
    }
    public Optional<DebitCard> findByCardNumber(String cardNumber) {
        if (cardNumber == null) {
            throw new IllegalArgumentException("cardNumber cannot be null");
        }
        return debitCardPersistenceAdapter.findByCardNumber(cardNumber);
    }

    public List<DebitCard> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return debitCardPersistenceAdapter.findByActive(active);
    }

    public List<DebitCard> findByClientId(Long clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("clientId cannot be null");
        }
        return debitCardPersistenceAdapter.findByClientId(clientId);
    }
}
