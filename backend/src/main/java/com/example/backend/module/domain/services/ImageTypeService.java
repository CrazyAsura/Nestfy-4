package com.example.backend.module.domain.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.ImageTypePersistenceAdapter;

@Service
public class ImageTypeService {

    private final ImageTypePersistenceAdapter imageTypePersistenceAdapter;

    @Autowired
    public ImageTypeService(ImageTypePersistenceAdapter imageTypePersistenceAdapter) {
        this.imageTypePersistenceAdapter = imageTypePersistenceAdapter;
    }

    public ImageType createImageType(ImageType imageType) {
        if (imageType == null) {
            throw new IllegalArgumentException("ImageType cannot be null");
        }
        return imageTypePersistenceAdapter.save(imageType);
    }

    public ImageType getImageType(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return imageTypePersistenceAdapter.findById(id).orElse(null);
    }

    public ImageType updateImageType(ImageType imageType) {
        if (imageType == null) {
            throw new IllegalArgumentException("ImageType cannot be null");
        }
        return imageTypePersistenceAdapter.save(imageType);
    }

    public void deleteImageType(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        imageTypePersistenceAdapter.deleteById(id);
    }
    public Optional<ImageType> findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("code cannot be null");
        }
        return imageTypePersistenceAdapter.findByCode(code);
    }
}
