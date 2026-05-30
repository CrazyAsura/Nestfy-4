package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.DebitCard;
import com.example.backend.module.domain.ports.out.IDebitCardRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateDebitCardUseCase;
import com.example.backend.module.domain.usecases.DeleteDebitCardUseCase;
import com.example.backend.module.domain.usecases.GetDebitCardUseCase;
import com.example.backend.module.domain.usecases.UpdateDebitCardUseCase;
import org.springframework.stereotype.Service;

@Service
public class DebitCardService {
    private final CreateDebitCardUseCase createDebitCardUseCase;
    private final GetDebitCardUseCase getDebitCardUseCase;
    private final UpdateDebitCardUseCase updateDebitCardUseCase;
    private final DeleteDebitCardUseCase deleteDebitCardUseCase;

    public DebitCardService(IDebitCardRepositoryPortOut debitCardRepositoryPortOut) {
        this.createDebitCardUseCase = new CreateDebitCardUseCase(debitCardRepositoryPortOut);
        this.getDebitCardUseCase = new GetDebitCardUseCase(debitCardRepositoryPortOut);
        this.updateDebitCardUseCase = new UpdateDebitCardUseCase(debitCardRepositoryPortOut);
        this.deleteDebitCardUseCase = new DeleteDebitCardUseCase(debitCardRepositoryPortOut);
    }

    public DebitCard createDebitCard(DebitCard debitcard) {
        return createDebitCardUseCase.execute(debitcard);
    }

    public DebitCard getDebitCard(Long id) {
        return getDebitCardUseCase.execute(id);
    }

    public DebitCard updateDebitCard(DebitCard debitcard) {
        return updateDebitCardUseCase.execute(debitcard);
    }

    public void deleteDebitCard(Long id) {
        deleteDebitCardUseCase.execute(id);
    }
}
