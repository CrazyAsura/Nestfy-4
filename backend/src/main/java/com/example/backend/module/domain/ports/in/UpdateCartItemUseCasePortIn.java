package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.CartItem;

public interface UpdateCartItemUseCasePortIn {
    CartItem execute(CartItem cartItem);
}
