package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.PaymentStatus;

public interface CreatePaymentStatusUseCasePortIn {
    PaymentStatus execute(PaymentStatus paymentStatus);
}
