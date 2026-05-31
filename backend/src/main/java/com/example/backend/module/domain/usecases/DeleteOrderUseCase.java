package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteOrderUseCasePortIn;
import com.example.backend.module.domain.ports.out.IOrderRepositoryPortOut;

@Component
public class DeleteOrderUseCase implements DeleteOrderUseCasePortIn {
    private final IOrderRepositoryPortOut orderRepositoryPortOut;

    public DeleteOrderUseCase(IOrderRepositoryPortOut orderRepositoryPortOut) {
        this.orderRepositoryPortOut = orderRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        orderRepositoryPortOut.deleteById(id);
    }
}

