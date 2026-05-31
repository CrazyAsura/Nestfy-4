package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteOrderItemUseCasePortIn;
import com.example.backend.module.domain.ports.out.IOrderItemRepositoryPortOut;

@Component
public class DeleteOrderItemUseCase implements DeleteOrderItemUseCasePortIn {
    private final IOrderItemRepositoryPortOut orderItemRepositoryPortOut;

    public DeleteOrderItemUseCase(IOrderItemRepositoryPortOut orderItemRepositoryPortOut) {
        this.orderItemRepositoryPortOut = orderItemRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        orderItemRepositoryPortOut.deleteById(id);
    }
}

