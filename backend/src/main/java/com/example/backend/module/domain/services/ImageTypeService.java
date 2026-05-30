package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.ImageType;
import com.example.backend.module.domain.ports.out.IImageTypeRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateImageTypeUseCase;
import com.example.backend.module.domain.usecases.DeleteImageTypeUseCase;
import com.example.backend.module.domain.usecases.GetImageTypeUseCase;
import com.example.backend.module.domain.usecases.UpdateImageTypeUseCase;
import org.springframework.stereotype.Service;

@Service
public class ImageTypeService {
    private final CreateImageTypeUseCase createImageTypeUseCase;
    private final GetImageTypeUseCase getImageTypeUseCase;
    private final UpdateImageTypeUseCase updateImageTypeUseCase;
    private final DeleteImageTypeUseCase deleteImageTypeUseCase;

    public ImageTypeService(IImageTypeRepositoryPortOut imageTypeRepositoryPortOut) {
        this.createImageTypeUseCase = new CreateImageTypeUseCase(imageTypeRepositoryPortOut);
        this.getImageTypeUseCase = new GetImageTypeUseCase(imageTypeRepositoryPortOut);
        this.updateImageTypeUseCase = new UpdateImageTypeUseCase(imageTypeRepositoryPortOut);
        this.deleteImageTypeUseCase = new DeleteImageTypeUseCase(imageTypeRepositoryPortOut);
    }

    public ImageType createImageType(ImageType imagetype) {
        return createImageTypeUseCase.execute(imagetype);
    }

    public ImageType getImageType(Long id) {
        return getImageTypeUseCase.execute(id);
    }

    public ImageType updateImageType(ImageType imagetype) {
        return updateImageTypeUseCase.execute(imagetype);
    }

    public void deleteImageType(Long id) {
        deleteImageTypeUseCase.execute(id);
    }
}
