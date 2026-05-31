package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.Sailor;
import com.example.backend.module.domain.ports.in.UpdateSailorUseCasePortIn;
import com.example.backend.module.domain.ports.out.ISailorRepositoryPortOut;

@Component
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
