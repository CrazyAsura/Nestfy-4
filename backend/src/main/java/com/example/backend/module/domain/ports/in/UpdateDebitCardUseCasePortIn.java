package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.DebitCard;

public interface UpdateDebitCardUseCasePortIn {
    DebitCard execute(DebitCard debitCard);
}
