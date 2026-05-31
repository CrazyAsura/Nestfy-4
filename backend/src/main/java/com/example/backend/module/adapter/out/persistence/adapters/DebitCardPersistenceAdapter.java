package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class DebitCardPersistenceAdapter {

    private final CreateDebitCardUseCase createDebitCardUseCase;
    private final GetDebitCardUseCase getDebitCardUseCase;
    private final UpdateDebitCardUseCase updateDebitCardUseCase;
    private final DeleteDebitCardUseCase deleteDebitCardUseCase;
    private final IDebitCardRepositoryPortOut debitCardRepositoryPortOut;

    @Autowired
    public DebitCardPersistenceAdapter(CreateDebitCardUseCase createDebitCardUseCase,
            GetDebitCardUseCase getDebitCardUseCase,
            UpdateDebitCardUseCase updateDebitCardUseCase,
            DeleteDebitCardUseCase deleteDebitCardUseCase,
            IDebitCardRepositoryPortOut debitCardRepositoryPortOut) {
        this.createDebitCardUseCase = createDebitCardUseCase;
        this.getDebitCardUseCase = getDebitCardUseCase;
        this.updateDebitCardUseCase = updateDebitCardUseCase;
        this.deleteDebitCardUseCase = deleteDebitCardUseCase;
        this.debitCardRepositoryPortOut = debitCardRepositoryPortOut;
    }

    public Optional<DebitCard> findById(Long id) {
        return Optional.ofNullable(getDebitCardUseCase.execute(id));
    }

    public Iterable<DebitCard> findAll() {
        return debitCardRepositoryPortOut.findAll();
    }

    public DebitCard save(DebitCard entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createDebitCardUseCase.execute(entity);
        } else {
            return updateDebitCardUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteDebitCardUseCase.execute(id);
    }
    public Optional<DebitCard> findByCardNumber(String cardNumber) {
        return debitCardRepositoryPortOut.findByCardNumber(cardNumber);
    }

    public List<DebitCard> findByActive(Boolean active) {
        return debitCardRepositoryPortOut.findByActive(active);
    }

    public List<DebitCard> findByClientId(Long clientId) {
        return debitCardRepositoryPortOut.findByClientId(clientId);
    }
}
