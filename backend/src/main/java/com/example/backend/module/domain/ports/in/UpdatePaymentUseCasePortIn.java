package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Payment;

public interface UpdatePaymentUseCasePortIn {
    Payment execute(Payment payment);
}
