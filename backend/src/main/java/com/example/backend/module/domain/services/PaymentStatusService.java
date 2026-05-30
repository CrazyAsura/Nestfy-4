package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.PaymentStatus;
import com.example.backend.module.domain.ports.out.IPaymentStatusRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreatePaymentStatusUseCase;
import com.example.backend.module.domain.usecases.DeletePaymentStatusUseCase;
import com.example.backend.module.domain.usecases.GetPaymentStatusUseCase;
import com.example.backend.module.domain.usecases.UpdatePaymentStatusUseCase;
import org.springframework.stereotype.Service;

@Service
public class PaymentStatusService {
    private final CreatePaymentStatusUseCase createPaymentStatusUseCase;
    private final GetPaymentStatusUseCase getPaymentStatusUseCase;
    private final UpdatePaymentStatusUseCase updatePaymentStatusUseCase;
    private final DeletePaymentStatusUseCase deletePaymentStatusUseCase;

    public PaymentStatusService(IPaymentStatusRepositoryPortOut paymentStatusRepositoryPortOut) {
        this.createPaymentStatusUseCase = new CreatePaymentStatusUseCase(paymentStatusRepositoryPortOut);
        this.getPaymentStatusUseCase = new GetPaymentStatusUseCase(paymentStatusRepositoryPortOut);
        this.updatePaymentStatusUseCase = new UpdatePaymentStatusUseCase(paymentStatusRepositoryPortOut);
        this.deletePaymentStatusUseCase = new DeletePaymentStatusUseCase(paymentStatusRepositoryPortOut);
    }

    public PaymentStatus createPaymentStatus(PaymentStatus paymentstatus) {
        return createPaymentStatusUseCase.execute(paymentstatus);
    }

    public PaymentStatus getPaymentStatus(Long id) {
        return getPaymentStatusUseCase.execute(id);
    }

    public PaymentStatus updatePaymentStatus(PaymentStatus paymentstatus) {
        return updatePaymentStatusUseCase.execute(paymentstatus);
    }

    public void deletePaymentStatus(Long id) {
        deletePaymentStatusUseCase.execute(id);
    }
}
