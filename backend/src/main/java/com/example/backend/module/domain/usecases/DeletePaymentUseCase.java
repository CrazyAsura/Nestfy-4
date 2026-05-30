package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeletePaymentUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentRepositoryPortOut;

public class DeletePaymentUseCase implements DeletePaymentUseCasePortIn {
    private final IPaymentRepositoryPortOut paymentRepositoryPortOut;

    public DeletePaymentUseCase(IPaymentRepositoryPortOut paymentRepositoryPortOut) {
        this.paymentRepositoryPortOut = paymentRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        paymentRepositoryPortOut.deleteById(id);
    }
}

