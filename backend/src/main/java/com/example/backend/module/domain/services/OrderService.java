package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Order;
import com.example.backend.module.domain.ports.out.IOrderRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateOrderUseCase;
import com.example.backend.module.domain.usecases.DeleteOrderUseCase;
import com.example.backend.module.domain.usecases.GetOrderUseCase;
import com.example.backend.module.domain.usecases.UpdateOrderUseCase;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;
    private final UpdateOrderUseCase updateOrderUseCase;
    private final DeleteOrderUseCase deleteOrderUseCase;

    public OrderService(IOrderRepositoryPortOut orderRepositoryPortOut) {
        this.createOrderUseCase = new CreateOrderUseCase(orderRepositoryPortOut);
        this.getOrderUseCase = new GetOrderUseCase(orderRepositoryPortOut);
        this.updateOrderUseCase = new UpdateOrderUseCase(orderRepositoryPortOut);
        this.deleteOrderUseCase = new DeleteOrderUseCase(orderRepositoryPortOut);
    }

    public Order createOrder(Order order) {
        return createOrderUseCase.execute(order);
    }

    public Order getOrder(Long id) {
        return getOrderUseCase.execute(id);
    }

    public Order updateOrder(Order order) {
        return updateOrderUseCase.execute(order);
    }

    public void deleteOrder(Long id) {
        deleteOrderUseCase.execute(id);
    }
}
