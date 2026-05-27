package com.example.backend.module.domain.models.interfaces;



import com.example.backend.module.domain.models.PaymentStatusEnum;

public abstract class IPaymentStatus {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract PaymentStatusEnum getStatus();
    public abstract void setStatus(PaymentStatusEnum status);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);
}