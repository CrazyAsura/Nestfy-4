package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Money;
import com.example.backend.module.domain.ports.in.GetMoneyUseCasePortIn;
import com.example.backend.module.domain.ports.out.IMoneyRepositoryPortOut;

public class GetMoneyUseCase implements GetMoneyUseCasePortIn {
    private final IMoneyRepositoryPortOut moneyRepositoryPortOut;

    public GetMoneyUseCase(IMoneyRepositoryPortOut moneyRepositoryPortOut) {
        this.moneyRepositoryPortOut = moneyRepositoryPortOut;
    }

    @Override
    public Money execute(Long id) {
        return moneyRepositoryPortOut.findById(id).orElse(null);
    }
}

