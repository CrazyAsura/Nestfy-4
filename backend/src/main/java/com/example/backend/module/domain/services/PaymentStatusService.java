package com.example.backend.module.domain.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.PaymentStatusPersistenceAdapter;

@Service
public class PaymentStatusService {

    private final PaymentStatusPersistenceAdapter paymentStatusPersistenceAdapter;

    @Autowired
    public PaymentStatusService(PaymentStatusPersistenceAdapter paymentStatusPersistenceAdapter) {
        this.paymentStatusPersistenceAdapter = paymentStatusPersistenceAdapter;
    }

    public PaymentStatus createPaymentStatus(PaymentStatus paymentStatus) {
        if (paymentStatus == null) {
            throw new IllegalArgumentException("PaymentStatus cannot be null");
        }
        return paymentStatusPersistenceAdapter.save(paymentStatus);
    }

    public PaymentStatus getPaymentStatus(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return paymentStatusPersistenceAdapter.findById(id).orElse(null);
    }

    public PaymentStatus updatePaymentStatus(PaymentStatus paymentStatus) {
        if (paymentStatus == null) {
            throw new IllegalArgumentException("PaymentStatus cannot be null");
        }
        return paymentStatusPersistenceAdapter.save(paymentStatus);
    }

    public void deletePaymentStatus(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        paymentStatusPersistenceAdapter.deleteById(id);
    }
    public Optional<PaymentStatus> findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("code cannot be null");
        }
        return paymentStatusPersistenceAdapter.findByCode(code);
    }

    public List<PaymentStatus> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return paymentStatusPersistenceAdapter.findByActive(active);
    }
}
