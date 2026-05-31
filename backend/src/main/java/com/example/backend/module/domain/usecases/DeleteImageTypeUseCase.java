package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteImageTypeUseCasePortIn;
import com.example.backend.module.domain.ports.out.IImageTypeRepositoryPortOut;

@Component
public class DeleteImageTypeUseCase implements DeleteImageTypeUseCasePortIn {
    private final IImageTypeRepositoryPortOut imageTypeRepositoryPortOut;

    public DeleteImageTypeUseCase(IImageTypeRepositoryPortOut imageTypeRepositoryPortOut) {
        this.imageTypeRepositoryPortOut = imageTypeRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        imageTypeRepositoryPortOut.deleteById(id);
    }
}

