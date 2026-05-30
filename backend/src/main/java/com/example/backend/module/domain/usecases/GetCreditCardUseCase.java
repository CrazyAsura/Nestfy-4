package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.CreditCard;
import com.example.backend.module.domain.ports.in.GetCreditCardUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICreditCardRepositoryPortOut;

public class GetCreditCardUseCase implements GetCreditCardUseCasePortIn {
    private final ICreditCardRepositoryPortOut creditCardRepositoryPortOut;

    public GetCreditCardUseCase(ICreditCardRepositoryPortOut creditCardRepositoryPortOut) {
        this.creditCardRepositoryPortOut = creditCardRepositoryPortOut;
    }

    @Override
    public CreditCard execute(Long id) {
        return creditCardRepositoryPortOut.findById(id).orElse(null);
    }
}

