package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Money;

public interface GetMoneyUseCasePortIn {
    Money execute(Long id);
}
