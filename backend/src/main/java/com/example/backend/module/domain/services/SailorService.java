package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Sailor;
import com.example.backend.module.domain.ports.out.ISailorRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateSailorUseCase;
import com.example.backend.module.domain.usecases.DeleteSailorUseCase;
import com.example.backend.module.domain.usecases.GetSailorUseCase;
import com.example.backend.module.domain.usecases.UpdateSailorUseCase;
import org.springframework.stereotype.Service;

@Service
public class SailorService {
    private final CreateSailorUseCase createSailorUseCase;
    private final GetSailorUseCase getSailorUseCase;
    private final UpdateSailorUseCase updateSailorUseCase;
    private final DeleteSailorUseCase deleteSailorUseCase;

    public SailorService(ISailorRepositoryPortOut sailorRepositoryPortOut) {
        this.createSailorUseCase = new CreateSailorUseCase(sailorRepositoryPortOut);
        this.getSailorUseCase = new GetSailorUseCase(sailorRepositoryPortOut);
        this.updateSailorUseCase = new UpdateSailorUseCase(sailorRepositoryPortOut);
        this.deleteSailorUseCase = new DeleteSailorUseCase(sailorRepositoryPortOut);
    }

    public Sailor createSailor(Sailor sailor) {
        return createSailorUseCase.execute(sailor);
    }

    public Sailor getSailor(Long id) {
        return getSailorUseCase.execute(id);
    }

    public Sailor updateSailor(Sailor sailor) {
        return updateSailorUseCase.execute(sailor);
    }

    public void deleteSailor(Long id) {
        deleteSailorUseCase.execute(id);
    }
}
