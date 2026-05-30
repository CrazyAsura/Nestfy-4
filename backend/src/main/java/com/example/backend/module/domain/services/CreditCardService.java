package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.CreditCard;
import com.example.backend.module.domain.ports.out.ICreditCardRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateCreditCardUseCase;
import com.example.backend.module.domain.usecases.DeleteCreditCardUseCase;
import com.example.backend.module.domain.usecases.GetCreditCardUseCase;
import com.example.backend.module.domain.usecases.UpdateCreditCardUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    private final CreateCreditCardUseCase createCreditCardUseCase;
    private final GetCreditCardUseCase getCreditCardUseCase;
    private final UpdateCreditCardUseCase updateCreditCardUseCase;
    private final DeleteCreditCardUseCase deleteCreditCardUseCase;

    public CreditCardService(ICreditCardRepositoryPortOut creditCardRepositoryPortOut) {
        this.createCreditCardUseCase = new CreateCreditCardUseCase(creditCardRepositoryPortOut);
        this.getCreditCardUseCase = new GetCreditCardUseCase(creditCardRepositoryPortOut);
        this.updateCreditCardUseCase = new UpdateCreditCardUseCase(creditCardRepositoryPortOut);
        this.deleteCreditCardUseCase = new DeleteCreditCardUseCase(creditCardRepositoryPortOut);
    }

    public CreditCard createCreditCard(CreditCard creditcard) {
        return createCreditCardUseCase.execute(creditcard);
    }

    public CreditCard getCreditCard(Long id) {
        return getCreditCardUseCase.execute(id);
    }

    public CreditCard updateCreditCard(CreditCard creditcard) {
        return updateCreditCardUseCase.execute(creditcard);
    }

    public void deleteCreditCard(Long id) {
        deleteCreditCardUseCase.execute(id);
    }
}
