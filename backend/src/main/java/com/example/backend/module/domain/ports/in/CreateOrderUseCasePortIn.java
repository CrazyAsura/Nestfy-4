package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Order;

public interface CreateOrderUseCasePortIn {
    Order execute(Order order);
}
