package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeletePaymentStatusUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentStatusRepositoryPortOut;

@Component
public class DeletePaymentStatusUseCase implements DeletePaymentStatusUseCasePortIn {
    private final IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut;

    public DeletePaymentStatusUseCase(IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut) {
        this.paymentStatusRepositoryPortOut = paymentStatusRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        paymentStatusRepositoryPortOut.deleteById(id);
    }
}

