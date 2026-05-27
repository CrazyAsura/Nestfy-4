package com.example.backend.module.domain.models;

public interface IDebitCard {
    Long getId();
    void setId(Long id);

    String getCardNumber();
    void setCardNumber(String cardNumber);

    String getCardName();
    void setCardName(String cardName);

    String getCardBrand();
    void setCardBrand(String cardBrand);

    String getCardType();
    void setCardType(String cardType);

    String getCardExpirationDate();
    void setCardExpirationDate(String cardExpirationDate);

    String getCardCvv();
    void setCardCvv(String cardCvv);

    Boolean getActive();
    void setActive(Boolean active);
}
