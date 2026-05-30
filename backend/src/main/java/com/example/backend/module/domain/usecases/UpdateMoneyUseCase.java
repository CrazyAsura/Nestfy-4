package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Money;
import com.example.backend.module.domain.ports.in.UpdateMoneyUseCasePortIn;
import com.example.backend.module.domain.ports.out.IMoneyRepositoryPortOut;

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

