package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteImageUseCasePortIn;
import com.example.backend.module.domain.ports.out.IImageRepositoryPortOut;

@Component
public class DeleteImageUseCase implements DeleteImageUseCasePortIn {
    private final IImageRepositoryPortOut imageRepositoryPortOut;

    public DeleteImageUseCase(IImageRepositoryPortOut imageRepositoryPortOut) {
        this.imageRepositoryPortOut = imageRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        imageRepositoryPortOut.deleteById(id);
    }
}

