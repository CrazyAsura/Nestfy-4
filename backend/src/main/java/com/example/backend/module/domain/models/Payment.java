package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment implements IPayment {

    private Long id;
    private Order order;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;
    private Double amount;
    
    public Payment(Long id, Order order, PaymentMethod paymentMethod, PaymentStatus status, Double amount) {
        this.id = id;
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.amount = amount;
    }

    public Payment() {
    }
}