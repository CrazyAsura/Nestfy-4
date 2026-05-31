package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class CreditCardPersistenceAdapter {

    private final CreateCreditCardUseCase createCreditCardUseCase;
    private final GetCreditCardUseCase getCreditCardUseCase;
    private final UpdateCreditCardUseCase updateCreditCardUseCase;
    private final DeleteCreditCardUseCase deleteCreditCardUseCase;
    private final ICreditCardRepositoryPortOut creditCardRepositoryPortOut;

    @Autowired
    public CreditCardPersistenceAdapter(CreateCreditCardUseCase createCreditCardUseCase,
            GetCreditCardUseCase getCreditCardUseCase,
            UpdateCreditCardUseCase updateCreditCardUseCase,
            DeleteCreditCardUseCase deleteCreditCardUseCase,
            ICreditCardRepositoryPortOut creditCardRepositoryPortOut) {
        this.createCreditCardUseCase = createCreditCardUseCase;
        this.getCreditCardUseCase = getCreditCardUseCase;
        this.updateCreditCardUseCase = updateCreditCardUseCase;
        this.deleteCreditCardUseCase = deleteCreditCardUseCase;
        this.creditCardRepositoryPortOut = creditCardRepositoryPortOut;
    }

    public Optional<CreditCard> findById(Long id) {
        return Optional.ofNullable(getCreditCardUseCase.execute(id));
    }

    public Iterable<CreditCard> findAll() {
        return creditCardRepositoryPortOut.findAll();
    }

    public CreditCard save(CreditCard entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createCreditCardUseCase.execute(entity);
        } else {
            return updateCreditCardUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteCreditCardUseCase.execute(id);
    }
    public Optional<CreditCard> findByCardNumber(String cardNumber) {
        return creditCardRepositoryPortOut.findByCardNumber(cardNumber);
    }

    public List<CreditCard> findByActive(Boolean active) {
        return creditCardRepositoryPortOut.findByActive(active);
    }
}
