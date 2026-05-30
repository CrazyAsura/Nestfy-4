package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Money;
import com.example.backend.module.domain.ports.out.IMoneyRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateMoneyUseCase;
import com.example.backend.module.domain.usecases.DeleteMoneyUseCase;
import com.example.backend.module.domain.usecases.GetMoneyUseCase;
import com.example.backend.module.domain.usecases.UpdateMoneyUseCase;
import org.springframework.stereotype.Service;

@Service
public class MoneyService {
    private final CreateMoneyUseCase createMoneyUseCase;
    private final GetMoneyUseCase getMoneyUseCase;
    private final UpdateMoneyUseCase updateMoneyUseCase;
    private final DeleteMoneyUseCase deleteMoneyUseCase;

    public MoneyService(IMoneyRepositoryPortOut moneyRepositoryPortOut) {
        this.createMoneyUseCase = new CreateMoneyUseCase(moneyRepositoryPortOut);
        this.getMoneyUseCase = new GetMoneyUseCase(moneyRepositoryPortOut);
        this.updateMoneyUseCase = new UpdateMoneyUseCase(moneyRepositoryPortOut);
        this.deleteMoneyUseCase = new DeleteMoneyUseCase(moneyRepositoryPortOut);
    }

    public Money createMoney(Money money) {
        return createMoneyUseCase.execute(money);
    }

    public Money getMoney(Long id) {
        return getMoneyUseCase.execute(id);
    }

    public Money updateMoney(Money money) {
        return updateMoneyUseCase.execute(money);
    }

    public void deleteMoney(Long id) {
        deleteMoneyUseCase.execute(id);
    }
}
