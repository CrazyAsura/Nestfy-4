package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.OrderItem;
import com.example.backend.module.domain.ports.in.UpdateOrderItemUseCasePortIn;
import com.example.backend.module.domain.ports.out.IOrderItemRepositoryPortOut;

public class UpdateOrderItemUseCase implements UpdateOrderItemUseCasePortIn {
    private final IOrderItemRepositoryPortOut orderItemRepositoryPortOut;

    public UpdateOrderItemUseCase(IOrderItemRepositoryPortOut orderItemRepositoryPortOut) {
        this.orderItemRepositoryPortOut = orderItemRepositoryPortOut;
    }

    @Override
    public OrderItem execute(OrderItem orderItem) {
        return orderItemRepositoryPortOut.save(orderItem);
    }
}

