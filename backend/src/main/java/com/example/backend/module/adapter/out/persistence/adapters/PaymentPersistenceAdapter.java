package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class PaymentPersistenceAdapter {

    private final CreatePaymentUseCase createPaymentUseCase;
    private final GetPaymentUseCase getPaymentUseCase;
    private final UpdatePaymentUseCase updatePaymentUseCase;
    private final DeletePaymentUseCase deletePaymentUseCase;
    private final ProcessPaymentUseCase processPaymentUseCase;
    private final IPaymentRepositoryPortOut paymentRepositoryPortOut;

    @Autowired
    public PaymentPersistenceAdapter(CreatePaymentUseCase createPaymentUseCase,
            GetPaymentUseCase getPaymentUseCase,
            UpdatePaymentUseCase updatePaymentUseCase,
            DeletePaymentUseCase deletePaymentUseCase,
            ProcessPaymentUseCase processPaymentUseCase,
            IPaymentRepositoryPortOut paymentRepositoryPortOut) {
        this.createPaymentUseCase = createPaymentUseCase;
        this.getPaymentUseCase = getPaymentUseCase;
        this.updatePaymentUseCase = updatePaymentUseCase;
        this.deletePaymentUseCase = deletePaymentUseCase;
        this.processPaymentUseCase = processPaymentUseCase;
        this.paymentRepositoryPortOut = paymentRepositoryPortOut;
    }

    public Optional<Payment> findById(Long id) {
        return Optional.ofNullable(getPaymentUseCase.execute(id));
    }

    public Iterable<Payment> findAll() {
        return paymentRepositoryPortOut.findAll();
    }

    public Payment save(Payment entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createPaymentUseCase.execute(entity);
        } else {
            return updatePaymentUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deletePaymentUseCase.execute(id);
    }
    public Payment processPayment(Payment payment) {
        return processPaymentUseCase.execute(payment);
    }

    public List<Payment> findByOrderId(Long orderId) {
        return paymentRepositoryPortOut.findByOrderId(orderId);
    }

    public List<Payment> findByPaymentMethodId(Long paymentMethodId) {
        return paymentRepositoryPortOut.findByPaymentMethodId(paymentMethodId);
    }

    public List<Payment> findByActive(Boolean active) {
        return paymentRepositoryPortOut.findByActive(active);
    }
}
