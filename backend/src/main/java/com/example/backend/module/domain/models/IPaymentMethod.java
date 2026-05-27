package com.example.backend.module.domain.models;

public interface IPaymentMethod {
    Long getId();
    void setId(Long id);

    PaymentMethodEnum getTypePaymentMethod();
    void setTypePaymentMethod(PaymentMethodEnum typePaymentMethod);

    Boolean getActive();
    void setActive(Boolean active);
}
