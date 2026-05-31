package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteDebitCardUseCasePortIn;
import com.example.backend.module.domain.ports.out.IDebitCardRepositoryPortOut;

@Component
public class DeleteDebitCardUseCase implements DeleteDebitCardUseCasePortIn {
    private final IDebitCardRepositoryPortOut debitCardRepositoryPortOut;

    public DeleteDebitCardUseCase(IDebitCardRepositoryPortOut debitCardRepositoryPortOut) {
        this.debitCardRepositoryPortOut = debitCardRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        debitCardRepositoryPortOut.deleteById(id);
    }
}

