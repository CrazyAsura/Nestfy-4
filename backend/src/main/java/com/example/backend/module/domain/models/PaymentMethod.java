package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethod implements IPaymentMethod {

    private Long id;
    private PaymentMethodEnum typePaymentMethod;
    private Boolean active;

    public PaymentMethod(Long id, PaymentMethodEnum typePaymentMethod, Boolean active) {
        this.id = id;
        this.typePaymentMethod = typePaymentMethod;
        this.active = active;
    }

    public PaymentMethod() {
    }
    
}