package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Order;
import com.example.backend.module.domain.ports.in.GetOrderUseCasePortIn;
import com.example.backend.module.domain.ports.out.IOrderRepositoryPortOut;

@Component
public class GetOrderUseCase implements GetOrderUseCasePortIn {
    private final IOrderRepositoryPortOut orderRepositoryPortOut;

    public GetOrderUseCase(IOrderRepositoryPortOut orderRepositoryPortOut) {
        this.orderRepositoryPortOut = orderRepositoryPortOut;
    }

    @Override
    public Order execute(Long id) {
        return orderRepositoryPortOut.findById(id).orElse(null);
    }
}

