package com.example.backend.module.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.OrderPersistenceAdapter;

@Service
public class OrderService {

    private final OrderPersistenceAdapter orderPersistenceAdapter;

    @Autowired
    public OrderService(OrderPersistenceAdapter orderPersistenceAdapter) {
        this.orderPersistenceAdapter = orderPersistenceAdapter;
    }

    public Order createOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        return orderPersistenceAdapter.save(order);
    }

    public Order getOrder(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return orderPersistenceAdapter.findById(id).orElse(null);
    }

    public Order updateOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        return orderPersistenceAdapter.save(order);
    }

    public void deleteOrder(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        orderPersistenceAdapter.deleteById(id);
    }
    public List<Order> findByUserId(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        return orderPersistenceAdapter.findByUserId(userId);
    }

    public List<Order> findByProductId(Long productId) {
        if (productId == null) {
            throw new IllegalArgumentException("productId cannot be null");
        }
        return orderPersistenceAdapter.findByProductId(productId);
    }

    public List<Order> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return orderPersistenceAdapter.findByActive(active);
    }
}
