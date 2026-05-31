package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class OrderDatabaseAdapter implements IOrderRepositoryPortOut {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return orderRepository.findAll().stream()
                .filter(o -> o.getClient() != null && o.getClient().getUser() != null && userId.equals(o.getClient().getUser().getId()))
                .toList();
    }

    @Override
    public List<Order> findByProductId(Long productId) {
        return orderRepository.findAll().stream()
                .filter(o -> o.getProduct() != null && o.getProduct().stream().anyMatch(p -> productId.equals(p.getId())))
                .toList();
    }

    @Override
    public List<Order> findByActive(Boolean active) {
        return orderRepository.findByActive(active);
    }
}
