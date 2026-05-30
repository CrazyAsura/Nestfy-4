package com.example.backend.module.domain.usecases;

import com.example.backend.module.domain.models.Sailor;
import com.example.backend.module.domain.ports.in.CreateSailorUseCasePortIn;
import com.example.backend.module.domain.ports.out.ISailorRepositoryPortOut;

public class CreateSailorUseCase implements CreateSailorUseCasePortIn {

    private final ISailorRepositoryPortOut sailorRepositoryPortOut;

    public CreateSailorUseCase(ISailorRepositoryPortOut sailorRepositoryPortOut) {
        this.sailorRepositoryPortOut = sailorRepositoryPortOut;
    }

    @Override
    public Sailor execute(Sailor sailor) {
        return sailorRepositoryPortOut.save(sailor);
    }
}
