package com.example.backend.module.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.CartPersistenceAdapter;

@Service
public class CartService {

    private final CartPersistenceAdapter cartPersistenceAdapter;

    @Autowired
    public CartService(CartPersistenceAdapter cartPersistenceAdapter) {
        this.cartPersistenceAdapter = cartPersistenceAdapter;
    }

    public Cart createCart(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }
        return cartPersistenceAdapter.save(cart);
    }

    public Cart getCart(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return cartPersistenceAdapter.findById(id).orElse(null);
    }

    public Cart updateCart(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }
        return cartPersistenceAdapter.save(cart);
    }

    public void deleteCart(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        cartPersistenceAdapter.deleteById(id);
    }
    public List<Cart> findByUserId(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        return cartPersistenceAdapter.findByUserId(userId);
    }

    public List<Cart> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return cartPersistenceAdapter.findByActive(active);
    }
}
