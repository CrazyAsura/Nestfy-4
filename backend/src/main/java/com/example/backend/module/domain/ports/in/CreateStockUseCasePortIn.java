package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Stock;

public interface CreateStockUseCasePortIn {
    Stock execute(Stock stock);
}
