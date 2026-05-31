package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;

import com.example.backend.module.domain.ports.in.DeleteSailorUseCasePortIn;
import com.example.backend.module.domain.ports.out.ISailorRepositoryPortOut;

@Component
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
