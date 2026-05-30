package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.Payment;

public interface IPaymentRepositoryPortOut extends IRepositoryPortOut<Payment, Long> {

    public List<Payment> findByOrderId(Long orderId);

    public List<Payment> findByPaymentMethodId(Long paymentMethodId);

    public List<Payment> findByActive(Boolean active);

}

