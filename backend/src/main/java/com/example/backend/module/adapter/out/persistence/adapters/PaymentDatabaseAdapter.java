package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class PaymentDatabaseAdapter implements IPaymentRepositoryPortOut {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment entity) {
        return paymentRepository.save(entity);
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Iterable<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> findByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    @Override
    public List<Payment> findByPaymentMethodId(Long paymentMethodId) {
        return new java.util.ArrayList<>();
    }

    @Override
    public List<Payment> findByActive(Boolean active) {
        return paymentRepository.findByActive(active);
    }
}
