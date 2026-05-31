package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.ImageType;
import com.example.backend.module.domain.ports.in.CreateImageTypeUseCasePortIn;
import com.example.backend.module.domain.ports.out.IImageTypeRepositoryPortOut;

@Component
public class CreateImageTypeUseCase implements CreateImageTypeUseCasePortIn {
    private final IImageTypeRepositoryPortOut imageTypeRepositoryPortOut;

    public CreateImageTypeUseCase(IImageTypeRepositoryPortOut imageTypeRepositoryPortOut) {
        this.imageTypeRepositoryPortOut = imageTypeRepositoryPortOut;
    }

    @Override
    public ImageType execute(ImageType imageType) {
        return imageTypeRepositoryPortOut.save(imageType);
    }
}



