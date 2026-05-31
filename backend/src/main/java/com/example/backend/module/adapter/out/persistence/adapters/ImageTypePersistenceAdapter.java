package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class ImageTypePersistenceAdapter {

    private final CreateImageTypeUseCase createImageTypeUseCase;
    private final GetImageTypeUseCase getImageTypeUseCase;
    private final UpdateImageTypeUseCase updateImageTypeUseCase;
    private final DeleteImageTypeUseCase deleteImageTypeUseCase;
    private final IImageTypeRepositoryPortOut imageTypeRepositoryPortOut;

    @Autowired
    public ImageTypePersistenceAdapter(CreateImageTypeUseCase createImageTypeUseCase,
            GetImageTypeUseCase getImageTypeUseCase,
            UpdateImageTypeUseCase updateImageTypeUseCase,
            DeleteImageTypeUseCase deleteImageTypeUseCase,
            IImageTypeRepositoryPortOut imageTypeRepositoryPortOut) {
        this.createImageTypeUseCase = createImageTypeUseCase;
        this.getImageTypeUseCase = getImageTypeUseCase;
        this.updateImageTypeUseCase = updateImageTypeUseCase;
        this.deleteImageTypeUseCase = deleteImageTypeUseCase;
        this.imageTypeRepositoryPortOut = imageTypeRepositoryPortOut;
    }

    public Optional<ImageType> findById(Long id) {
        return Optional.ofNullable(getImageTypeUseCase.execute(id));
    }

    public Iterable<ImageType> findAll() {
        return imageTypeRepositoryPortOut.findAll();
    }

    public ImageType save(ImageType entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createImageTypeUseCase.execute(entity);
        } else {
            return updateImageTypeUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteImageTypeUseCase.execute(id);
    }
    public Optional<ImageType> findByCode(String code) {
        return imageTypeRepositoryPortOut.findByCode(code);
    }
}
