package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Image;
import com.example.backend.module.domain.ports.in.CreateImageUseCasePortIn;
import com.example.backend.module.domain.ports.out.IImageRepositoryPortOut;

public class CreateImageUseCase implements CreateImageUseCasePortIn {
    private final IImageRepositoryPortOut imageRepositoryPortOut;

    public CreateImageUseCase(IImageRepositoryPortOut imageRepositoryPortOut) {
        this.imageRepositoryPortOut = imageRepositoryPortOut;
    }

    @Override
    public Image execute(Image image) {
        return imageRepositoryPortOut.save(image);
    }
}



