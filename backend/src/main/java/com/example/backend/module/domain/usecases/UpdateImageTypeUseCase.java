package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.ImageType;
import com.example.backend.module.domain.ports.in.UpdateImageTypeUseCasePortIn;
import com.example.backend.module.domain.ports.out.IImageTypeRepositoryPortOut;

public class UpdateImageTypeUseCase implements UpdateImageTypeUseCasePortIn {
    private final IImageTypeRepositoryPortOut imageTypeRepositoryPortOut;

    public UpdateImageTypeUseCase(IImageTypeRepositoryPortOut imageTypeRepositoryPortOut) {
        this.imageTypeRepositoryPortOut = imageTypeRepositoryPortOut;
    }

    @Override
    public ImageType execute(ImageType imageType) {
        return imageTypeRepositoryPortOut.save(imageType);
    }
}

