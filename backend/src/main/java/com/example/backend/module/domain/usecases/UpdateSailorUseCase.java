package com.example.backend.module.domain.usecases;

import com.example.backend.module.domain.models.Sailor;
import com.example.backend.module.domain.ports.in.UpdateSailorUseCasePortIn;
import com.example.backend.module.domain.ports.out.ISailorRepositoryPortOut;

public class UpdateSailorUseCase implements UpdateSailorUseCasePortIn {

    private final ISailorRepositoryPortOut sailorRepositoryPortOut;

    public UpdateSailorUseCase(ISailorRepositoryPortOut sailorRepositoryPortOut) {
        this.sailorRepositoryPortOut = sailorRepositoryPortOut;
    }

    @Override
    public Sailor execute(Sailor sailor) {
        return sailorRepositoryPortOut.save(sailor);
    }
}
