package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Payment;
import com.example.backend.module.domain.ports.in.GetPaymentUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentRepositoryPortOut;

@Component
public class GetPaymentUseCase implements GetPaymentUseCasePortIn {
    private final IPaymentRepositoryPortOut paymentRepositoryPortOut;

    public GetPaymentUseCase(IPaymentRepositoryPortOut paymentRepositoryPortOut) {
        this.paymentRepositoryPortOut = paymentRepositoryPortOut;
    }

    @Override
    public Payment execute(Long id) {
        return paymentRepositoryPortOut.findById(id).orElse(null);
    }
}

