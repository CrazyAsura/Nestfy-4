package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class OrderItemPersistenceAdapter {

    private final CreateOrderItemUseCase createOrderItemUseCase;
    private final GetOrderItemUseCase getOrderItemUseCase;
    private final UpdateOrderItemUseCase updateOrderItemUseCase;
    private final DeleteOrderItemUseCase deleteOrderItemUseCase;
    private final IOrderItemRepositoryPortOut orderItemRepositoryPortOut;

    @Autowired
    public OrderItemPersistenceAdapter(CreateOrderItemUseCase createOrderItemUseCase,
            GetOrderItemUseCase getOrderItemUseCase,
            UpdateOrderItemUseCase updateOrderItemUseCase,
            DeleteOrderItemUseCase deleteOrderItemUseCase,
            IOrderItemRepositoryPortOut orderItemRepositoryPortOut) {
        this.createOrderItemUseCase = createOrderItemUseCase;
        this.getOrderItemUseCase = getOrderItemUseCase;
        this.updateOrderItemUseCase = updateOrderItemUseCase;
        this.deleteOrderItemUseCase = deleteOrderItemUseCase;
        this.orderItemRepositoryPortOut = orderItemRepositoryPortOut;
    }

    public Optional<OrderItem> findById(Long id) {
        return Optional.ofNullable(getOrderItemUseCase.execute(id));
    }

    public Iterable<OrderItem> findAll() {
        return orderItemRepositoryPortOut.findAll();
    }

    public OrderItem save(OrderItem entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createOrderItemUseCase.execute(entity);
        } else {
            return updateOrderItemUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteOrderItemUseCase.execute(id);
    }
    public List<OrderItem> findByOrderId(Long orderId) {
        return orderItemRepositoryPortOut.findByOrderId(orderId);
    }

    public List<OrderItem> findByProductId(Long productId) {
        return orderItemRepositoryPortOut.findByProductId(productId);
    }

    public List<OrderItem> findByActive(Boolean active) {
        return orderItemRepositoryPortOut.findByActive(active);
    }
}
