package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeletePaymentStatusUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPaymentStatusRepositoryPortOut;

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

