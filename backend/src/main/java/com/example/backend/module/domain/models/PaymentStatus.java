package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentStatus implements IPaymentStatus {

    private Long id;
    private PaymentStatusEnum status;
    private Boolean active;
    
    public PaymentStatus(Long id, PaymentStatusEnum status, Boolean active) {
        this.id = id;
        this.status = status;
        this.active = active;
    }

    public PaymentStatus() {
    }
}
