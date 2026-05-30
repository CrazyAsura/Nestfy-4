package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.OrderItem;

public interface IOrderItemRepositoryPortOut extends IRepositoryPortOut<OrderItem, Long> {

    public List<OrderItem> findByOrderId(Long orderId);

    public List<OrderItem> findByProductId(Long productId);

    public List<OrderItem> findByActive(Boolean active);

}
