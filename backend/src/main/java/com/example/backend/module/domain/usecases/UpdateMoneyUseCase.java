package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Money;
import com.example.backend.module.domain.ports.in.UpdateMoneyUseCasePortIn;
import com.example.backend.module.domain.ports.out.IMoneyRepositoryPortOut;

@Component
public class UpdateMoneyUseCase implements UpdateMoneyUseCasePortIn {
    private final IMoneyRepositoryPortOut moneyRepositoryPortOut;

    public UpdateMoneyUseCase(IMoneyRepositoryPortOut moneyRepositoryPortOut) {
        this.moneyRepositoryPortOut = moneyRepositoryPortOut;
    }

    @Override
    public Money execute(Money money) {
        return moneyRepositoryPortOut.save(money);
    }
}

