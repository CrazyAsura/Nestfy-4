package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Payment;
import com.example.backend.module.domain.ports.in.CreatePaymentUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentRepositoryPortOut;

public class CreatePaymentUseCase implements CreatePaymentUseCasePortIn {
    private final IPaymentRepositoryPortOut paymentRepositoryPortOut;

    public CreatePaymentUseCase(IPaymentRepositoryPortOut paymentRepositoryPortOut) {
        this.paymentRepositoryPortOut = paymentRepositoryPortOut;
    }

    @Override
    public Payment execute(Payment payment) {
        return paymentRepositoryPortOut.save(payment);
    }
}



