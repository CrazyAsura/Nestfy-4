package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.PaymentStatus;
import com.example.backend.module.domain.ports.in.CreatePaymentStatusUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentStatusRepositoryPortOut;

@Component
public class CreatePaymentStatusUseCase implements CreatePaymentStatusUseCasePortIn {
    private final IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut;

    public CreatePaymentStatusUseCase(IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut) {
        this.paymentStatusRepositoryPortOut = paymentStatusRepositoryPortOut;
    }

    @Override
    public PaymentStatus execute(PaymentStatus paymentStatus) {
        return paymentStatusRepositoryPortOut.save(paymentStatus);
    }
}



