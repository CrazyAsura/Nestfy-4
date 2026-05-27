package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.CartItem;

public interface CartItemRepositoryPortOut extends IRepositoryPortOut<CartItem, Long> {

    public List<CartItem> findByCartId(Long cartId);
    public List<CartItem> findByActive(Boolean active);

}
