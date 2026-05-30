package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Payment;  
import com.example.backend.module.domain.ports.in.ProcessPaymentUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentRepositoryPortOut;

public class ProcessPaymentUseCase implements ProcessPaymentUseCasePortIn {
    private final IPaymentRepositoryPortOut paymentRepositoryPortOut;

    public ProcessPaymentUseCase(IPaymentRepositoryPortOut paymentRepositoryPortOut) {
        this.paymentRepositoryPortOut = paymentRepositoryPortOut;
    }

    @Override
    public Payment execute(Payment payment) {
        return paymentRepositoryPortOut.save(payment);
    }
}

