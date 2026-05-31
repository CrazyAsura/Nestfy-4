package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteMoneyUseCasePortIn;
import com.example.backend.module.domain.ports.out.IMoneyRepositoryPortOut;

@Component
public class DeleteMoneyUseCase implements DeleteMoneyUseCasePortIn {
    private final IMoneyRepositoryPortOut moneyRepositoryPortOut;

    public DeleteMoneyUseCase(IMoneyRepositoryPortOut moneyRepositoryPortOut) {
        this.moneyRepositoryPortOut = moneyRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        moneyRepositoryPortOut.deleteById(id);
    }
}

