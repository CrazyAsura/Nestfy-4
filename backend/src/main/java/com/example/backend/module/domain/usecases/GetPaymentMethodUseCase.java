package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.PaymentMethod;
import com.example.backend.module.domain.ports.in.GetPaymentMethodUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentMethodRepositoryPortOut;

public class GetPaymentMethodUseCase implements GetPaymentMethodUseCasePortIn {
    private final IPaymentMethodRepositoryPortOut paymentMethodRepositoryPortOut;

    public GetPaymentMethodUseCase(IPaymentMethodRepositoryPortOut paymentMethodRepositoryPortOut) {
        this.paymentMethodRepositoryPortOut = paymentMethodRepositoryPortOut;
    }

    @Override
    public PaymentMethod execute(Long id) {
        return paymentMethodRepositoryPortOut.findById(id).orElse(null);
    }
}

