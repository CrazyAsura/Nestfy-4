package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Order;
import com.example.backend.module.domain.ports.in.CreateOrderUseCasePortIn;
import com.example.backend.module.domain.ports.out.IOrderRepositoryPortOut;

public class CreateOrderUseCase implements CreateOrderUseCasePortIn {
    private final IOrderRepositoryPortOut orderRepositoryPortOut;

    public CreateOrderUseCase(IOrderRepositoryPortOut orderRepositoryPortOut) {
        this.orderRepositoryPortOut = orderRepositoryPortOut;
    }

    @Override
    public Order execute(Order order) {
        return orderRepositoryPortOut.save(order);
    }
}



