package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.DebitCard;
import com.example.backend.module.domain.ports.in.CreateDebitCardUseCasePortIn;
import com.example.backend.module.domain.ports.out.IDebitCardRepositoryPortOut;

@Component
public class CreateDebitCardUseCase implements CreateDebitCardUseCasePortIn {
    private final IDebitCardRepositoryPortOut debitCardRepositoryPortOut;

    public CreateDebitCardUseCase(IDebitCardRepositoryPortOut debitCardRepositoryPortOut) {
        this.debitCardRepositoryPortOut = debitCardRepositoryPortOut;
    }

    @Override
    public DebitCard execute(DebitCard debitCard) {
        return debitCardRepositoryPortOut.save(debitCard);
    }
}



