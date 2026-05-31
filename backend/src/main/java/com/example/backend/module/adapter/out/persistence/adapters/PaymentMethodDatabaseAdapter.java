package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class PaymentMethodDatabaseAdapter implements IPaymentMethodRepositoryPortOut {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod save(PaymentMethod entity) {
        return paymentMethodRepository.save(entity);
    }

    @Override
    public Optional<PaymentMethod> findById(Long id) {
        return paymentMethodRepository.findById(id);
    }

    @Override
    public Iterable<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        paymentMethodRepository.deleteById(id);
    }

    @Override
    public List<PaymentMethod> findByClientId(Long clientId) {
        return new java.util.ArrayList<>();
    }

    @Override
    public List<PaymentMethod> findByActive(Boolean active) {
        return paymentMethodRepository.findByActive(active);
    }
}
