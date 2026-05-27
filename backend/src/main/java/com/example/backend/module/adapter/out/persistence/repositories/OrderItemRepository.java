package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Order;
import com.example.backend.module.domain.models.OrderItem;
import com.example.backend.module.domain.models.Product;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    public List<OrderItem> findByOrder(Order order);

    public List<OrderItem> findByProduct(Product product);
}
