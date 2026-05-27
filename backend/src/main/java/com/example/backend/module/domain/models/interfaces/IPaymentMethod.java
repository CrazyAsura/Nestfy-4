package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.PaymentMethodEnum;

public abstract class IPaymentMethod {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract PaymentMethodEnum getTypePaymentMethod();
    public abstract void setTypePaymentMethod(PaymentMethodEnum typePaymentMethod);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);
}