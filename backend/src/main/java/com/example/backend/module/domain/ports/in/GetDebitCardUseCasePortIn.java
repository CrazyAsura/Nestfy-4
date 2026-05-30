package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.DebitCard;

public interface GetDebitCardUseCasePortIn {
    DebitCard execute(Long id);
}
