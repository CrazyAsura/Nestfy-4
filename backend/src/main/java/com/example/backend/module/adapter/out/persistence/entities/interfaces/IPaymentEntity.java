package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.adapter.out.persistence.entities.*;

@Getter
@Setter
public abstract class IPaymentEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract OrderEntity getOrder();
    public abstract void setOrder(OrderEntity order);

    public abstract PaymentMethodEntity getPaymentMethod();
    public abstract void setPaymentMethod(PaymentMethodEntity paymentMethod);

    public abstract PaymentStatusEntity getStatus();
    public abstract void setStatus(PaymentStatusEntity status);

    public abstract Double getAmount();
    public abstract void setAmount(Double amount);
}
