package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.OrderItem;
import com.example.backend.module.domain.ports.in.GetOrderItemUseCasePortIn;
import com.example.backend.module.domain.ports.out.IOrderItemRepositoryPortOut;

@Component
public class GetOrderItemUseCase implements GetOrderItemUseCasePortIn {
    private final IOrderItemRepositoryPortOut orderItemRepositoryPortOut;

    public GetOrderItemUseCase(IOrderItemRepositoryPortOut orderItemRepositoryPortOut) {
        this.orderItemRepositoryPortOut = orderItemRepositoryPortOut;
    }

    @Override
    public OrderItem execute(Long id) {
        return orderItemRepositoryPortOut.findById(id).orElse(null);
    }
}
