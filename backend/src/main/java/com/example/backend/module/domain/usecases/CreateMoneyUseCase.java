package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Money;
import com.example.backend.module.domain.ports.in.CreateMoneyUseCasePortIn;
import com.example.backend.module.domain.ports.out.IMoneyRepositoryPortOut;

public class CreateMoneyUseCase implements CreateMoneyUseCasePortIn {
    private final IMoneyRepositoryPortOut moneyRepositoryPortOut;

    public CreateMoneyUseCase(IMoneyRepositoryPortOut moneyRepositoryPortOut) {
        this.moneyRepositoryPortOut = moneyRepositoryPortOut;
    }

    @Override
    public Money execute(Money money) {
        return moneyRepositoryPortOut.save(money);
    }
}



