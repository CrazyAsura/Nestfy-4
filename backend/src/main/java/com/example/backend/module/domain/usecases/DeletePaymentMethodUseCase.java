package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeletePaymentMethodUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentMethodRepositoryPortOut;

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

