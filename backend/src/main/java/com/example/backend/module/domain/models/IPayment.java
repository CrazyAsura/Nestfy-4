package com.example.backend.module.domain.models;

public interface IPayment {
    Long getId();
    void setId(Long id);

    Order getOrder();
    void setOrder(Order order);

    PaymentMethod getPaymentMethod();
    void setPaymentMethod(PaymentMethod paymentMethod);

    PaymentStatus getStatus();
    void setStatus(PaymentStatus status);

    Double getAmount();
    void setAmount(Double amount);
}
