package com.example.backend.module.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.OrderItemPersistenceAdapter;

@Service
public class OrderItemService {

    private final OrderItemPersistenceAdapter orderItemPersistenceAdapter;

    @Autowired
    public OrderItemService(OrderItemPersistenceAdapter orderItemPersistenceAdapter) {
        this.orderItemPersistenceAdapter = orderItemPersistenceAdapter;
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("OrderItem cannot be null");
        }
        return orderItemPersistenceAdapter.save(orderItem);
    }

    public OrderItem getOrderItem(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return orderItemPersistenceAdapter.findById(id).orElse(null);
    }

    public OrderItem updateOrderItem(OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("OrderItem cannot be null");
        }
        return orderItemPersistenceAdapter.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        orderItemPersistenceAdapter.deleteById(id);
    }
    public List<OrderItem> findByOrderId(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException("orderId cannot be null");
        }
        return orderItemPersistenceAdapter.findByOrderId(orderId);
    }

    public List<OrderItem> findByProductId(Long productId) {
        if (productId == null) {
            throw new IllegalArgumentException("productId cannot be null");
        }
        return orderItemPersistenceAdapter.findByProductId(productId);
    }

    public List<OrderItem> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return orderItemPersistenceAdapter.findByActive(active);
    }
}
