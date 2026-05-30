package com.example.backend.module.domain.factory.interfaces;

import com.example.backend.module.domain.models.PaymentMethod;
import com.example.backend.module.domain.models.PaymentMethodEnum;

public interface IPaymentMethodFactory {
    PaymentMethod createPaymentMethod(Long id, PaymentMethodEnum typePaymentMethod, Boolean active);
}
