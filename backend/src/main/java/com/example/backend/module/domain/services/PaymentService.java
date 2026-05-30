package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Payment;
import com.example.backend.module.domain.ports.out.IPaymentRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreatePaymentUseCase;
import com.example.backend.module.domain.usecases.DeletePaymentUseCase;
import com.example.backend.module.domain.usecases.GetPaymentUseCase;
import com.example.backend.module.domain.usecases.ProcessPaymentUseCase;
import com.example.backend.module.domain.usecases.UpdatePaymentUseCase;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final CreatePaymentUseCase createPaymentUseCase;
    private final GetPaymentUseCase getPaymentUseCase;
    private final UpdatePaymentUseCase updatePaymentUseCase;
    private final DeletePaymentUseCase deletePaymentUseCase;
    private final ProcessPaymentUseCase processPaymentUseCase;

    public PaymentService(IPaymentRepositoryPortOut paymentRepositoryPortOut) {
        this.createPaymentUseCase = new CreatePaymentUseCase(paymentRepositoryPortOut);
        this.getPaymentUseCase = new GetPaymentUseCase(paymentRepositoryPortOut);
        this.updatePaymentUseCase = new UpdatePaymentUseCase(paymentRepositoryPortOut);
        this.deletePaymentUseCase = new DeletePaymentUseCase(paymentRepositoryPortOut);
        this.processPaymentUseCase = new ProcessPaymentUseCase(paymentRepositoryPortOut);
    }

    public Payment createPayment(Payment payment) {
        return createPaymentUseCase.execute(payment);
    }

    public Payment getPayment(Long id) {
        return getPaymentUseCase.execute(id);
    }

    public Payment updatePayment(Payment payment) {
        return updatePaymentUseCase.execute(payment);
    }

    public void deletePayment(Long id) {
        deletePaymentUseCase.execute(id);
    }

    public Payment processPayment(Payment payment) {
        return processPaymentUseCase.execute(payment);
    }
}
