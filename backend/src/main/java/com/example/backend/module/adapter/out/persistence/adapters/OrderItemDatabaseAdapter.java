package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class OrderItemDatabaseAdapter implements IOrderItemRepositoryPortOut {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem save(OrderItem entity) {
        return orderItemRepository.save(entity);
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public Iterable<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {
        return orderItemRepository.findAll().stream()
                .filter(oi -> oi.getOrder() != null && orderId.equals(oi.getOrder().getId()))
                .toList();
    }

    @Override
    public List<OrderItem> findByProductId(Long productId) {
        return orderItemRepository.findAll().stream()
                .filter(oi -> oi.getProduct() != null && productId.equals(oi.getProduct().getId()))
                .toList();
    }

    @Override
    public List<OrderItem> findByActive(Boolean active) {
        return new java.util.ArrayList<>();
    }
}
