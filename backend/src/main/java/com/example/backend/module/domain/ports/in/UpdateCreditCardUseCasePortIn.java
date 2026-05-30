package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.CreditCard;

public interface UpdateCreditCardUseCasePortIn {
    CreditCard execute(CreditCard creditCard);
}
