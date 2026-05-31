package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.DebitCard;
import com.example.backend.module.domain.ports.in.GetDebitCardUseCasePortIn;
import com.example.backend.module.domain.ports.out.IDebitCardRepositoryPortOut;

@Component
public class GetDebitCardUseCase implements GetDebitCardUseCasePortIn {
    private final IDebitCardRepositoryPortOut debitCardRepositoryPortOut;

    public GetDebitCardUseCase(IDebitCardRepositoryPortOut debitCardRepositoryPortOut) {
        this.debitCardRepositoryPortOut = debitCardRepositoryPortOut;
    }

    @Override
    public DebitCard execute(Long id) {
        return debitCardRepositoryPortOut.findById(id).orElse(null);
    }
}

