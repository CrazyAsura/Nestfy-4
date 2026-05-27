package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;
import com.example.backend.module.domain.models.PaymentMethodEnum;

@Getter
@Setter
public abstract class IPaymentMethodEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract PaymentMethodEnum getTypePaymentMethod();
    public abstract void setTypePaymentMethod(PaymentMethodEnum typePaymentMethod);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);
}
