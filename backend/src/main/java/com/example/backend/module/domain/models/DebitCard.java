package com.example.backend.module.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DebitCard implements IDebitCard {

    private Long id;
    private String cardNumber;
    private String cardName;
    private String cardBrand;
    private String cardType;
    private String cardExpirationDate;
    private String cardCvv;
    private Boolean active;
    
    public DebitCard(Long id, String cardNumber, String cardName, String cardBrand, String cardType, String cardExpirationDate, String cardCvv, Boolean active) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardBrand = cardBrand;
        this.cardType = cardType;
        this.cardExpirationDate = cardExpirationDate;
        this.cardCvv = cardCvv;
        this.active = active;
    }

    public DebitCard() {
    }
}