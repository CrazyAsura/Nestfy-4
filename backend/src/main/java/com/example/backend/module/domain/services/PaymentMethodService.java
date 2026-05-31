package com.example.backend.module.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.PaymentMethodPersistenceAdapter;

@Service
public class PaymentMethodService {

    private final PaymentMethodPersistenceAdapter paymentMethodPersistenceAdapter;

    @Autowired
    public PaymentMethodService(PaymentMethodPersistenceAdapter paymentMethodPersistenceAdapter) {
        this.paymentMethodPersistenceAdapter = paymentMethodPersistenceAdapter;
    }

    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException("PaymentMethod cannot be null");
        }
        return paymentMethodPersistenceAdapter.save(paymentMethod);
    }

    public PaymentMethod getPaymentMethod(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return paymentMethodPersistenceAdapter.findById(id).orElse(null);
    }

    public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException("PaymentMethod cannot be null");
        }
        return paymentMethodPersistenceAdapter.save(paymentMethod);
    }

    public void deletePaymentMethod(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        paymentMethodPersistenceAdapter.deleteById(id);
    }
    public List<PaymentMethod> findByClientId(Long clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("clientId cannot be null");
        }
        return paymentMethodPersistenceAdapter.findByClientId(clientId);
    }

    public List<PaymentMethod> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return paymentMethodPersistenceAdapter.findByActive(active);
    }
}
