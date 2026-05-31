package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.ImageType;
import com.example.backend.module.domain.ports.in.GetImageTypeUseCasePortIn;
import com.example.backend.module.domain.ports.out.IImageTypeRepositoryPortOut;

@Component
public class GetImageTypeUseCase implements GetImageTypeUseCasePortIn {
    private final IImageTypeRepositoryPortOut imageTypeRepositoryPortOut;

    public GetImageTypeUseCase(IImageTypeRepositoryPortOut imageTypeRepositoryPortOut) {
        this.imageTypeRepositoryPortOut = imageTypeRepositoryPortOut;
    }

    @Override
    public ImageType execute(Long id) {
        return imageTypeRepositoryPortOut.findById(id).orElse(null);
    }
}

