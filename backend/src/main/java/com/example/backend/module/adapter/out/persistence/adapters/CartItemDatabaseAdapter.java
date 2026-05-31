package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class CartItemDatabaseAdapter implements ICartItemRepositoryPortOut {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem save(CartItem entity) {
        return cartItemRepository.save(entity);
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return cartItemRepository.findById(id);
    }

    @Override
    public Iterable<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public List<CartItem> findByCartId(Long cartId) {
        return cartItemRepository.findAll().stream()
                .filter(ci -> ci.getCart() != null && cartId.equals(ci.getCart().getId()))
                .toList();
    }

    @Override
    public List<CartItem> findByActive(Boolean active) {
        return new java.util.ArrayList<>();
    }
}
