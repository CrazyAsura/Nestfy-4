package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class CartDatabaseAdapter implements ICartRepositoryPortOut {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart save(Cart entity) {
        return cartRepository.save(entity);
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Iterable<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> findByUserId(Long userId) {
        return cartRepository.findAll().stream()
                .filter(c -> c.getUser() != null && userId.equals(c.getUser().getId()))
                .toList();
    }

    @Override
    public List<Cart> findByActive(Boolean active) {
        return new java.util.ArrayList<>();
    }
}
