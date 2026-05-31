package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.PaymentStatus;
import com.example.backend.module.domain.ports.in.UpdatePaymentStatusUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentStatusRepositoryPortOut;

@Component
public class UpdatePaymentStatusUseCase implements UpdatePaymentStatusUseCasePortIn {
    private final IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut;

    public UpdatePaymentStatusUseCase(IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut) {
        this.paymentStatusRepositoryPortOut = paymentStatusRepositoryPortOut;
    }

    @Override
    public PaymentStatus execute(PaymentStatus paymentStatus) {
        return paymentStatusRepositoryPortOut.save(paymentStatus);
    }
}

