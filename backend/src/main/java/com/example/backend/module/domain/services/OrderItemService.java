package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.OrderItem;
import com.example.backend.module.domain.ports.out.IOrderItemRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateOrderItemUseCase;
import com.example.backend.module.domain.usecases.DeleteOrderItemUseCase;
import com.example.backend.module.domain.usecases.GetOrderItemUseCase;
import com.example.backend.module.domain.usecases.UpdateOrderItemUseCase;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
    private final CreateOrderItemUseCase createOrderItemUseCase;
    private final GetOrderItemUseCase getOrderItemUseCase;
    private final UpdateOrderItemUseCase updateOrderItemUseCase;
    private final DeleteOrderItemUseCase deleteOrderItemUseCase;

    public OrderItemService(IOrderItemRepositoryPortOut orderItemRepositoryPortOut) {
        this.createOrderItemUseCase = new CreateOrderItemUseCase(orderItemRepositoryPortOut);
        this.getOrderItemUseCase = new GetOrderItemUseCase(orderItemRepositoryPortOut);
        this.updateOrderItemUseCase = new UpdateOrderItemUseCase(orderItemRepositoryPortOut);
        this.deleteOrderItemUseCase = new DeleteOrderItemUseCase(orderItemRepositoryPortOut);
    }

    public OrderItem createOrderItem(OrderItem orderitem) {
        return createOrderItemUseCase.execute(orderitem);
    }

    public OrderItem getOrderItem(Long id) {
        return getOrderItemUseCase.execute(id);
    }

    public OrderItem updateOrderItem(OrderItem orderitem) {
        return updateOrderItemUseCase.execute(orderitem);
    }

    public void deleteOrderItem(Long id) {
        deleteOrderItemUseCase.execute(id);
    }
}
