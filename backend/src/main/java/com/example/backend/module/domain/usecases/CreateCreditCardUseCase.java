package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.CreditCard;
import com.example.backend.module.domain.ports.in.CreateCreditCardUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICreditCardRepositoryPortOut;

public class CreateCreditCardUseCase implements CreateCreditCardUseCasePortIn {
    
    private final ICreditCardRepositoryPortOut creditCardRepositoryPortOut;

    public CreateCreditCardUseCase(ICreditCardRepositoryPortOut creditCardRepositoryPortOut) {
        this.creditCardRepositoryPortOut = creditCardRepositoryPortOut;
    }

    @Override
    public CreditCard execute(CreditCard creditCard) {
        return creditCardRepositoryPortOut.save(creditCard);
    }
}



