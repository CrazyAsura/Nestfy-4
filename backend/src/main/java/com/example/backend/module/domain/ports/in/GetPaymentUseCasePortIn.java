package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Payment;

public interface GetPaymentUseCasePortIn {
    Payment execute(Long id);
}
