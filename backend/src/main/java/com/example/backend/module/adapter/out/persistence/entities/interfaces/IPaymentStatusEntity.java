package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.domain.models.PaymentStatusEnum;

@Getter
@Setter
public abstract class IPaymentStatusEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract PaymentStatusEnum getStatus();
    public abstract void setStatus(PaymentStatusEnum status);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);
}
