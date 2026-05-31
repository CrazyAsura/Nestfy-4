package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.DebitCard;
import com.example.backend.module.domain.ports.in.UpdateDebitCardUseCasePortIn;
import com.example.backend.module.domain.ports.out.IDebitCardRepositoryPortOut;

@Component
public class UpdateDebitCardUseCase implements UpdateDebitCardUseCasePortIn {
    private final IDebitCardRepositoryPortOut debitCardRepositoryPortOut;

    public UpdateDebitCardUseCase(IDebitCardRepositoryPortOut debitCardRepositoryPortOut) {
        this.debitCardRepositoryPortOut = debitCardRepositoryPortOut;
    }

    @Override
    public DebitCard execute(DebitCard debitCard) {
        return debitCardRepositoryPortOut.save(debitCard);
    }
}

