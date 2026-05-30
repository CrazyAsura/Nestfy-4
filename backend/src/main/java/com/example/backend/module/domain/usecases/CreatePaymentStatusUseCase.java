package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.PaymentStatus;
import com.example.backend.module.domain.ports.in.CreatePaymentStatusUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentStatusRepositoryPortOut;

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



