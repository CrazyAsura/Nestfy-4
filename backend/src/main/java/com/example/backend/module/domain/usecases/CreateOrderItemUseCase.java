package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.OrderItem;
import com.example.backend.module.domain.ports.in.CreateOrderItemUseCasePortIn;
import com.example.backend.module.domain.ports.out.IOrderItemRepositoryPortOut;

public class CreateOrderItemUseCase implements CreateOrderItemUseCasePortIn {
    private final IOrderItemRepositoryPortOut orderItemRepositoryPortOut;

    public CreateOrderItemUseCase(IOrderItemRepositoryPortOut orderItemRepositoryPortOut) {
        this.orderItemRepositoryPortOut = orderItemRepositoryPortOut;
    }

    @Override
    public OrderItem execute(OrderItem orderItem) {
        return orderItemRepositoryPortOut.save(orderItem);
    }
}



