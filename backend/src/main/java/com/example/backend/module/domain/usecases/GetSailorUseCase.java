package com.example.backend.module.domain.usecases;

import com.example.backend.module.domain.models.Sailor;
import com.example.backend.module.domain.ports.in.GetSailorUseCasePortIn;
import com.example.backend.module.domain.ports.out.ISailorRepositoryPortOut;

public class GetSailorUseCase implements GetSailorUseCasePortIn {

    private final ISailorRepositoryPortOut sailorRepositoryPortOut;

    public GetSailorUseCase(ISailorRepositoryPortOut sailorRepositoryPortOut) {
        this.sailorRepositoryPortOut = sailorRepositoryPortOut;
    }

    @Override
    public Sailor execute(Long id) {
        return sailorRepositoryPortOut.findById(id).orElse(null);
    }
}
