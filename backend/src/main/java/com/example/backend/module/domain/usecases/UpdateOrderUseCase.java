package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Order;
import com.example.backend.module.domain.ports.in.UpdateOrderUseCasePortIn;
import com.example.backend.module.domain.ports.out.IOrderRepositoryPortOut;

public class UpdateOrderUseCase implements UpdateOrderUseCasePortIn {
    private final IOrderRepositoryPortOut orderRepositoryPortOut;

    public UpdateOrderUseCase(IOrderRepositoryPortOut orderRepositoryPortOut) {
        this.orderRepositoryPortOut = orderRepositoryPortOut;
    }

    @Override
    public Order execute(Order order) {
        return orderRepositoryPortOut.save(order);
    }
}

