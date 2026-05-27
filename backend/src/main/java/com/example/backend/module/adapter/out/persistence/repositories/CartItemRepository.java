package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Cart;
import com.example.backend.module.domain.models.CartItem;
import com.example.backend.module.domain.models.Product;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    public List<CartItem> findByCart(Cart cart);

    public List<CartItem> findByProduct(Product product);
}
