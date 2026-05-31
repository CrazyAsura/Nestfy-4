package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Image;
import com.example.backend.module.domain.ports.in.GetImageUseCasePortIn;
import com.example.backend.module.domain.ports.out.IImageRepositoryPortOut;

@Component
public class GetImageUseCase implements GetImageUseCasePortIn {
    private final IImageRepositoryPortOut imageRepositoryPortOut;

    public GetImageUseCase(IImageRepositoryPortOut imageRepositoryPortOut) {
        this.imageRepositoryPortOut = imageRepositoryPortOut;
    }

    @Override
    public Image execute(Long id) {
        return imageRepositoryPortOut.findById(id).orElse(null);
    }
}

