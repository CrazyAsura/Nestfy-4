package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Image;
import com.example.backend.module.domain.ports.out.IImageRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateImageUseCase;
import com.example.backend.module.domain.usecases.DeleteImageUseCase;
import com.example.backend.module.domain.usecases.GetImageUseCase;
import com.example.backend.module.domain.usecases.UpdateImageUseCase;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final CreateImageUseCase createImageUseCase;
    private final GetImageUseCase getImageUseCase;
    private final UpdateImageUseCase updateImageUseCase;
    private final DeleteImageUseCase deleteImageUseCase;

    public ImageService(IImageRepositoryPortOut imageRepositoryPortOut) {
        this.createImageUseCase = new CreateImageUseCase(imageRepositoryPortOut);
        this.getImageUseCase = new GetImageUseCase(imageRepositoryPortOut);
        this.updateImageUseCase = new UpdateImageUseCase(imageRepositoryPortOut);
        this.deleteImageUseCase = new DeleteImageUseCase(imageRepositoryPortOut);
    }

    public Image createImage(Image image) {
        return createImageUseCase.execute(image);
    }

    public Image getImage(Long id) {
        return getImageUseCase.execute(id);
    }

    public Image updateImage(Image image) {
        return updateImageUseCase.execute(image);
    }

    public void deleteImage(Long id) {
        deleteImageUseCase.execute(id);
    }
}
