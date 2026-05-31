package com.example.backend.module.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.ImagePersistenceAdapter;

@Service
public class ImageService {

    private final ImagePersistenceAdapter imagePersistenceAdapter;

    @Autowired
    public ImageService(ImagePersistenceAdapter imagePersistenceAdapter) {
        this.imagePersistenceAdapter = imagePersistenceAdapter;
    }

    public Image createImage(Image image) {
        if (image == null) {
            throw new IllegalArgumentException("Image cannot be null");
        }
        return imagePersistenceAdapter.save(image);
    }

    public Image getImage(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return imagePersistenceAdapter.findById(id).orElse(null);
    }

    public Image updateImage(Image image) {
        if (image == null) {
            throw new IllegalArgumentException("Image cannot be null");
        }
        return imagePersistenceAdapter.save(image);
    }

    public void deleteImage(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        imagePersistenceAdapter.deleteById(id);
    }
    public List<Image> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return imagePersistenceAdapter.findByActive(active);
    }
}
