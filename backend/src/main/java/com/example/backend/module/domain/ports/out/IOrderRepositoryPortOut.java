package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.Order;

public interface IOrderRepositoryPortOut extends IRepositoryPortOut<Order, Long> {

    public List<Order> findByUserId(Long userId);

    public List<Order> findByProductId(Long productId);

    public List<Order> findByActive(Boolean active);

}

