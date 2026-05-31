package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Image;
import com.example.backend.module.domain.ports.in.UpdateImageUseCasePortIn;
import com.example.backend.module.domain.ports.out.IImageRepositoryPortOut;

@Component
public class UpdateImageUseCase implements UpdateImageUseCasePortIn {
    private final IImageRepositoryPortOut imageRepositoryPortOut;

    public UpdateImageUseCase(IImageRepositoryPortOut imageRepositoryPortOut) {
        this.imageRepositoryPortOut = imageRepositoryPortOut;
    }

    @Override
    public Image execute(Image image) {
        return imageRepositoryPortOut.save(image);
    }
}

