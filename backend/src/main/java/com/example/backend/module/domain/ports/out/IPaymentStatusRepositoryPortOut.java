package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.PaymentStatus;

public interface IPaymentStatusRepositoryPortOut extends IRepositoryPortOut<PaymentStatus, Long> {

    public Optional<PaymentStatus> findByCode(String code);

    public List<PaymentStatus> findByActive(Boolean active);

}

