package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class ImagePersistenceAdapter {

    private final CreateImageUseCase createImageUseCase;
    private final GetImageUseCase getImageUseCase;
    private final UpdateImageUseCase updateImageUseCase;
    private final DeleteImageUseCase deleteImageUseCase;
    private final IImageRepositoryPortOut imageRepositoryPortOut;

    @Autowired
    public ImagePersistenceAdapter(CreateImageUseCase createImageUseCase,
            GetImageUseCase getImageUseCase,
            UpdateImageUseCase updateImageUseCase,
            DeleteImageUseCase deleteImageUseCase,
            IImageRepositoryPortOut imageRepositoryPortOut) {
        this.createImageUseCase = createImageUseCase;
        this.getImageUseCase = getImageUseCase;
        this.updateImageUseCase = updateImageUseCase;
        this.deleteImageUseCase = deleteImageUseCase;
        this.imageRepositoryPortOut = imageRepositoryPortOut;
    }

    public Optional<Image> findById(Long id) {
        return Optional.ofNullable(getImageUseCase.execute(id));
    }

    public Iterable<Image> findAll() {
        return imageRepositoryPortOut.findAll();
    }

    public Image save(Image entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createImageUseCase.execute(entity);
        } else {
            return updateImageUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteImageUseCase.execute(id);
    }
    public List<Image> findByActive(Boolean active) {
        return imageRepositoryPortOut.findByActive(active);
    }
}
