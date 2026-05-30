package com.example.backend.module.domain.ports.in;
    
import com.example.backend.module.domain.models.Payment;

public interface ProcessPaymentUseCasePortIn {
    Payment execute(Payment payment);
}
