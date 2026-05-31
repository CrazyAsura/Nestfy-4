package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class PaymentMethodPersistenceAdapter {

    private final CreatePaymentMethodUseCase createPaymentMethodUseCase;
    private final GetPaymentMethodUseCase getPaymentMethodUseCase;
    private final UpdatePaymentMethodUseCase updatePaymentMethodUseCase;
    private final DeletePaymentMethodUseCase deletePaymentMethodUseCase;
    private final IPaymentMethodRepositoryPortOut paymentMethodRepositoryPortOut;

    @Autowired
    public PaymentMethodPersistenceAdapter(CreatePaymentMethodUseCase createPaymentMethodUseCase,
            GetPaymentMethodUseCase getPaymentMethodUseCase,
            UpdatePaymentMethodUseCase updatePaymentMethodUseCase,
            DeletePaymentMethodUseCase deletePaymentMethodUseCase,
            IPaymentMethodRepositoryPortOut paymentMethodRepositoryPortOut) {
        this.createPaymentMethodUseCase = createPaymentMethodUseCase;
        this.getPaymentMethodUseCase = getPaymentMethodUseCase;
        this.updatePaymentMethodUseCase = updatePaymentMethodUseCase;
        this.deletePaymentMethodUseCase = deletePaymentMethodUseCase;
        this.paymentMethodRepositoryPortOut = paymentMethodRepositoryPortOut;
    }

    public Optional<PaymentMethod> findById(Long id) {
        return Optional.ofNullable(getPaymentMethodUseCase.execute(id));
    }

    public Iterable<PaymentMethod> findAll() {
        return paymentMethodRepositoryPortOut.findAll();
    }

    public PaymentMethod save(PaymentMethod entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createPaymentMethodUseCase.execute(entity);
        } else {
            return updatePaymentMethodUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deletePaymentMethodUseCase.execute(id);
    }
    public List<PaymentMethod> findByClientId(Long clientId) {
        return paymentMethodRepositoryPortOut.findByClientId(clientId);
    }

    public List<PaymentMethod> findByActive(Boolean active) {
        return paymentMethodRepositoryPortOut.findByActive(active);
    }
}
