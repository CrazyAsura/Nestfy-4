package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.CreditCard;
import com.example.backend.module.domain.ports.in.UpdateCreditCardUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICreditCardRepositoryPortOut;

public class UpdateCreditCardUseCase implements UpdateCreditCardUseCasePortIn {
    private final ICreditCardRepositoryPortOut creditCardRepositoryPortOut;

    public UpdateCreditCardUseCase(ICreditCardRepositoryPortOut creditCardRepositoryPortOut) {
        this.creditCardRepositoryPortOut = creditCardRepositoryPortOut;
    }

    @Override
    public CreditCard execute(CreditCard creditCard) {
        return creditCardRepositoryPortOut.save(creditCard);
    }
}

