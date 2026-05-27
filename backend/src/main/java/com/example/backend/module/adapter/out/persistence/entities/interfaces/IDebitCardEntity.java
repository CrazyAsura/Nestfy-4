package com.example.backend.module.adapter.out.persistence.entities.interfaces;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IDebitCardEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public abstract String getCardNumber();
    public abstract void setCardNumber(String cardNumber);

    public abstract String getCardName();
    public abstract void setCardName(String cardName);

    public abstract String getCardBrand();
    public abstract void setCardBrand(String cardBrand);

    public abstract String getCardType();
    public abstract void setCardType(String cardType);

    public abstract String getCardExpirationDate();
    public abstract void setCardExpirationDate(String cardExpirationDate);

    public abstract String getCardCvv();
    public abstract void setCardCvv(String cardCvv);

    public abstract Boolean getActive();
    public abstract void setActive(Boolean active);
}
