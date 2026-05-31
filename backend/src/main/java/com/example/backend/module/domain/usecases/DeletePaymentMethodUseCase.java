package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeletePaymentMethodUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentMethodRepositoryPortOut;

@Component
public class DeletePaymentMethodUseCase implements DeletePaymentMethodUseCasePortIn {
    private final IPaymentMethodRepositoryPortOut paymentMethodRepositoryPortOut;

    public DeletePaymentMethodUseCase(IPaymentMethodRepositoryPortOut paymentMethodRepositoryPortOut) {
        this.paymentMethodRepositoryPortOut = paymentMethodRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        paymentMethodRepositoryPortOut.deleteById(id);
    }
}

