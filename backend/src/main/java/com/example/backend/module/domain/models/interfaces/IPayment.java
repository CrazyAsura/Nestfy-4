package com.example.backend.module.domain.models.interfaces;

import com.example.backend.module.domain.models.*;


public abstract class IPayment {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract Order getOrder();
    public abstract void setOrder(Order order);

    public abstract PaymentMethod getPaymentMethod();
    public abstract void setPaymentMethod(PaymentMethod paymentMethod);

    public abstract PaymentStatus getStatus();
    public abstract void setStatus(PaymentStatus status);

    public abstract Double getAmount();
    public abstract void setAmount(Double amount);
}