package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.PaymentMethod;
import com.example.backend.module.domain.ports.in.UpdatePaymentMethodUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentMethodRepositoryPortOut;

@Component
public class UpdatePaymentMethodUseCase implements UpdatePaymentMethodUseCasePortIn {
    private final IPaymentMethodRepositoryPortOut paymentMethodRepositoryPortOut;

    public UpdatePaymentMethodUseCase(IPaymentMethodRepositoryPortOut paymentMethodRepositoryPortOut) {
        this.paymentMethodRepositoryPortOut = paymentMethodRepositoryPortOut;
    }

    @Override
    public PaymentMethod execute(PaymentMethod paymentMethod) {
        return paymentMethodRepositoryPortOut.save(paymentMethod);
    }
}

