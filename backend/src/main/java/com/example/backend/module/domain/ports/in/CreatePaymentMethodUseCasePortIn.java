package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.PaymentMethod;

public interface CreatePaymentMethodUseCasePortIn {
    PaymentMethod execute(PaymentMethod paymentMethod);
}
