package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.PaymentStatus;

public interface UpdatePaymentStatusUseCasePortIn {
    PaymentStatus execute(PaymentStatus paymentStatus);
}
