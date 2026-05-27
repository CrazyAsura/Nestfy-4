package com.example.backend.module.domain.models.interfaces;




public abstract class ICreditCard {

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