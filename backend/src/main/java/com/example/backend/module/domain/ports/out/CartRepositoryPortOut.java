package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.Cart;

public interface CartRepositoryPortOut extends IRepositoryPortOut<Cart, Long> {

    public List<Cart> findByUserId(Long userId);
    public List<Cart> findByActive(Boolean active);

}