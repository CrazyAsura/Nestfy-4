package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.PaymentStatus;
import com.example.backend.module.domain.ports.in.GetPaymentStatusUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentStatusRepositoryPortOut;

public class GetPaymentStatusUseCase implements GetPaymentStatusUseCasePortIn {
    private final IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut;

    public GetPaymentStatusUseCase(IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut) {
        this.paymentStatusRepositoryPortOut = paymentStatusRepositoryPortOut;
    }

    @Override
    public PaymentStatus execute(Long id) {
        return paymentStatusRepositoryPortOut.findById(id).orElse(null);
    }
}

