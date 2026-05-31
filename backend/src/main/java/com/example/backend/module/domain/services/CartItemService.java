package com.example.backend.module.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.CartItemPersistenceAdapter;

@Service
public class CartItemService {

    private final CartItemPersistenceAdapter cartItemPersistenceAdapter;

    @Autowired
    public CartItemService(CartItemPersistenceAdapter cartItemPersistenceAdapter) {
        this.cartItemPersistenceAdapter = cartItemPersistenceAdapter;
    }

    public CartItem createCartItem(CartItem cartItem) {
        if (cartItem == null) {
            throw new IllegalArgumentException("CartItem cannot be null");
        }
        return cartItemPersistenceAdapter.save(cartItem);
    }

    public CartItem getCartItem(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return cartItemPersistenceAdapter.findById(id).orElse(null);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        if (cartItem == null) {
            throw new IllegalArgumentException("CartItem cannot be null");
        }
        return cartItemPersistenceAdapter.save(cartItem);
    }

    public void deleteCartItem(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        cartItemPersistenceAdapter.deleteById(id);
    }
    public List<CartItem> findByCartId(Long cartId) {
        if (cartId == null) {
            throw new IllegalArgumentException("cartId cannot be null");
        }
        return cartItemPersistenceAdapter.findByCartId(cartId);
    }

    public List<CartItem> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return cartItemPersistenceAdapter.findByActive(active);
    }
}
