package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.PaymentMethod;
import com.example.backend.module.domain.ports.out.IPaymentMethodRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreatePaymentMethodUseCase;
import com.example.backend.module.domain.usecases.DeletePaymentMethodUseCase;
import com.example.backend.module.domain.usecases.GetPaymentMethodUseCase;
import com.example.backend.module.domain.usecases.UpdatePaymentMethodUseCase;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {
    private final CreatePaymentMethodUseCase createPaymentMethodUseCase;
    private final GetPaymentMethodUseCase getPaymentMethodUseCase;
    private final UpdatePaymentMethodUseCase updatePaymentMethodUseCase;
    private final DeletePaymentMethodUseCase deletePaymentMethodUseCase;

    public PaymentMethodService(IPaymentMethodRepositoryPortOut paymentMethodRepositoryPortOut) {
        this.createPaymentMethodUseCase = new CreatePaymentMethodUseCase(paymentMethodRepositoryPortOut);
        this.getPaymentMethodUseCase = new GetPaymentMethodUseCase(paymentMethodRepositoryPortOut);
        this.updatePaymentMethodUseCase = new UpdatePaymentMethodUseCase(paymentMethodRepositoryPortOut);
        this.deletePaymentMethodUseCase = new DeletePaymentMethodUseCase(paymentMethodRepositoryPortOut);
    }

    public PaymentMethod createPaymentMethod(PaymentMethod paymentmethod) {
        return createPaymentMethodUseCase.execute(paymentmethod);
    }

    public PaymentMethod getPaymentMethod(Long id) {
        return getPaymentMethodUseCase.execute(id);
    }

    public PaymentMethod updatePaymentMethod(PaymentMethod paymentmethod) {
        return updatePaymentMethodUseCase.execute(paymentmethod);
    }

    public void deletePaymentMethod(Long id) {
        deletePaymentMethodUseCase.execute(id);
    }
}
