package com.example.backend.module.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.PaymentPersistenceAdapter;

@Service
public class PaymentService {

    private final PaymentPersistenceAdapter paymentPersistenceAdapter;

    @Autowired
    public PaymentService(PaymentPersistenceAdapter paymentPersistenceAdapter) {
        this.paymentPersistenceAdapter = paymentPersistenceAdapter;
    }

    public Payment createPayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        return paymentPersistenceAdapter.save(payment);
    }

    public Payment getPayment(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return paymentPersistenceAdapter.findById(id).orElse(null);
    }

    public Payment updatePayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        return paymentPersistenceAdapter.save(payment);
    }

    public void deletePayment(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        paymentPersistenceAdapter.deleteById(id);
    }
    public Payment processPayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        return paymentPersistenceAdapter.processPayment(payment);
    }

    public List<Payment> findByOrderId(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException("orderId cannot be null");
        }
        return paymentPersistenceAdapter.findByOrderId(orderId);
    }

    public List<Payment> findByPaymentMethodId(Long paymentMethodId) {
        if (paymentMethodId == null) {
            throw new IllegalArgumentException("paymentMethodId cannot be null");
        }
        return paymentPersistenceAdapter.findByPaymentMethodId(paymentMethodId);
    }

    public List<Payment> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return paymentPersistenceAdapter.findByActive(active);
    }
}
