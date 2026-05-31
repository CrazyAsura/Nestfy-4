package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteCreditCardUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICreditCardRepositoryPortOut;

@Component
public class DeleteCreditCardUseCase implements DeleteCreditCardUseCasePortIn {
    private final ICreditCardRepositoryPortOut creditCardRepositoryPortOut;

    public DeleteCreditCardUseCase(ICreditCardRepositoryPortOut creditCardRepositoryPortOut) {
        this.creditCardRepositoryPortOut = creditCardRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        creditCardRepositoryPortOut.deleteById(id);
    }
}

