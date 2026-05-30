package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteCreditCardUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICreditCardRepositoryPortOut;

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

