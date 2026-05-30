package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Cart;

public interface CreateCartUseCasePortIn {
    Cart execute(Cart cart);
}
