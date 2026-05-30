package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.CartItem;

public interface GetCartItemUseCasePortIn {
    CartItem execute(Long id);
}
