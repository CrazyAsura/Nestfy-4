package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class PaymentStatusPersistenceAdapter {

    private final CreatePaymentStatusUseCase createPaymentStatusUseCase;
    private final GetPaymentStatusUseCase getPaymentStatusUseCase;
    private final UpdatePaymentStatusUseCase updatePaymentStatusUseCase;
    private final DeletePaymentStatusUseCase deletePaymentStatusUseCase;
    private final IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut;

    @Autowired
    public PaymentStatusPersistenceAdapter(CreatePaymentStatusUseCase createPaymentStatusUseCase,
            GetPaymentStatusUseCase getPaymentStatusUseCase,
            UpdatePaymentStatusUseCase updatePaymentStatusUseCase,
            DeletePaymentStatusUseCase deletePaymentStatusUseCase,
            IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut) {
        this.createPaymentStatusUseCase = createPaymentStatusUseCase;
        this.getPaymentStatusUseCase = getPaymentStatusUseCase;
        this.updatePaymentStatusUseCase = updatePaymentStatusUseCase;
        this.deletePaymentStatusUseCase = deletePaymentStatusUseCase;
        this.paymentStatusRepositoryPortOut = paymentStatusRepositoryPortOut;
    }

    public Optional<PaymentStatus> findById(Long id) {
        return Optional.ofNullable(getPaymentStatusUseCase.execute(id));
    }

    public Iterable<PaymentStatus> findAll() {
        return paymentStatusRepositoryPortOut.findAll();
    }

    public PaymentStatus save(PaymentStatus entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createPaymentStatusUseCase.execute(entity);
        } else {
            return updatePaymentStatusUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deletePaymentStatusUseCase.execute(id);
    }
    public Optional<PaymentStatus> findByCode(String code) {
        return paymentStatusRepositoryPortOut.findByCode(code);
    }

    public List<PaymentStatus> findByActive(Boolean active) {
        return paymentStatusRepositoryPortOut.findByActive(active);
    }
}
