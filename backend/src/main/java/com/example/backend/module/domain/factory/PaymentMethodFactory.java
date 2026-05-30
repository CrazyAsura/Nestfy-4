package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.PaymentMethod;
import com.example.backend.module.domain.models.PaymentMethodEnum;
import com.example.backend.module.domain.factory.interfaces.IPaymentMethodFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodFactory implements IPaymentMethodFactory {

    @Override
    public PaymentMethod createPaymentMethod(Long id, PaymentMethodEnum typePaymentMethod, Boolean active) {
        return new PaymentMethod(id, typePaymentMethod, active);
    }
}
