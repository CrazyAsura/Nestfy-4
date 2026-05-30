package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Payment;
import com.example.backend.module.domain.ports.in.GetPaymentUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentRepositoryPortOut;

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

