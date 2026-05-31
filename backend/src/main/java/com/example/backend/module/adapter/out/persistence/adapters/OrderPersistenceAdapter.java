package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class OrderPersistenceAdapter {

    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;
    private final UpdateOrderUseCase updateOrderUseCase;
    private final DeleteOrderUseCase deleteOrderUseCase;
    private final IOrderRepositoryPortOut orderRepositoryPortOut;

    @Autowired
    public OrderPersistenceAdapter(CreateOrderUseCase createOrderUseCase,
            GetOrderUseCase getOrderUseCase,
            UpdateOrderUseCase updateOrderUseCase,
            DeleteOrderUseCase deleteOrderUseCase,
            IOrderRepositoryPortOut orderRepositoryPortOut) {
        this.createOrderUseCase = createOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.updateOrderUseCase = updateOrderUseCase;
        this.deleteOrderUseCase = deleteOrderUseCase;
        this.orderRepositoryPortOut = orderRepositoryPortOut;
    }

    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(getOrderUseCase.execute(id));
    }

    public Iterable<Order> findAll() {
        return orderRepositoryPortOut.findAll();
    }

    public Order save(Order entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createOrderUseCase.execute(entity);
        } else {
            return updateOrderUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteOrderUseCase.execute(id);
    }
    public List<Order> findByUserId(Long userId) {
        return orderRepositoryPortOut.findByUserId(userId);
    }

    public List<Order> findByProductId(Long productId) {
        return orderRepositoryPortOut.findByProductId(productId);
    }

    public List<Order> findByActive(Boolean active) {
        return orderRepositoryPortOut.findByActive(active);
    }
}
