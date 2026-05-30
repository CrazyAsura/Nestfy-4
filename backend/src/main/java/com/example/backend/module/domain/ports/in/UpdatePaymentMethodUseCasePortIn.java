package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.PaymentMethod;

public interface UpdatePaymentMethodUseCasePortIn {
    PaymentMethod execute(PaymentMethod paymentMethod);
}
