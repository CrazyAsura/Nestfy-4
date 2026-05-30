package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.CreditCard;

public interface CreateCreditCardUseCasePortIn {
    CreditCard execute(CreditCard creditCard);
}
