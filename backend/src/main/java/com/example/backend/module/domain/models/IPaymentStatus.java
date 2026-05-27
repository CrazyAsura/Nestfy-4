package com.example.backend.module.domain.models;

public interface IPaymentStatus {
    Long getId();
    void setId(Long id);

    PaymentStatusEnum getStatus();
    void setStatus(PaymentStatusEnum status);

    Boolean getActive();
    void setActive(Boolean active);
}
