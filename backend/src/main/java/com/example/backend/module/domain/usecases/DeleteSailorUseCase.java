package com.example.backend.module.domain.usecases;

import com.example.backend.module.domain.ports.in.DeleteSailorUseCasePortIn;
import com.example.backend.module.domain.ports.out.ISailorRepositoryPortOut;

public class DeleteSailorUseCase implements DeleteSailorUseCasePortIn {

    private final ISailorRepositoryPortOut sailorRepositoryPortOut;

    public DeleteSailorUseCase(ISailorRepositoryPortOut sailorRepositoryPortOut) {
        this.sailorRepositoryPortOut = sailorRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        sailorRepositoryPortOut.deleteById(id);
    }
}
