package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.PaymentMethod;

public interface IPaymentMethodRepositoryPortOut extends IRepositoryPortOut<PaymentMethod, Long> {

    public List<PaymentMethod> findByClientId(Long clientId);

    public List<PaymentMethod> findByActive(Boolean active);

}

