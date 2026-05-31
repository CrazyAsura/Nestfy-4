package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class PaymentStatusDatabaseAdapter implements IPaymentStatusRepositoryPortOut {

    @Autowired
    private PaymentStatusRepository paymentStatusRepository;

    @Override
    public PaymentStatus save(PaymentStatus entity) {
        return paymentStatusRepository.save(entity);
    }

    @Override
    public Optional<PaymentStatus> findById(Long id) {
        return paymentStatusRepository.findById(id);
    }

    @Override
    public Iterable<PaymentStatus> findAll() {
        return paymentStatusRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        paymentStatusRepository.deleteById(id);
    }

    @Override
    public Optional<PaymentStatus> findByCode(String code) {
        try {
            PaymentStatusEnum statusEnum = PaymentStatusEnum.valueOf(code);
            return paymentStatusRepository.findByStatus(statusEnum).stream().findFirst();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<PaymentStatus> findByActive(Boolean active) {
        return paymentStatusRepository.findByActive(active);
    }
}
