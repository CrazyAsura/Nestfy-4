package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.OrderItem;

public interface GetOrderItemUseCasePortIn {
    OrderItem execute(Long id);
}
