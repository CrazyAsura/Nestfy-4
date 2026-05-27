package com.example.backend.module.domain.models;

import com.example.backend.module.domain.models.interfaces.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentStatus extends IPaymentStatus{

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