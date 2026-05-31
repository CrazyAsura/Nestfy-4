package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class ImageTypeDatabaseAdapter implements IImageTypeRepositoryPortOut {

    @Autowired
    private ImageTypeRepository imageTypeRepository;

    @Override
    public ImageType save(ImageType entity) {
        return imageTypeRepository.save(entity);
    }

    @Override
    public Optional<ImageType> findById(Long id) {
        return imageTypeRepository.findById(id);
    }

    @Override
    public Iterable<ImageType> findAll() {
        return imageTypeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        imageTypeRepository.deleteById(id);
    }

    @Override
    public Optional<ImageType> findByCode(String code) {
        try {
            ImageTypeEnum typeEnum = ImageTypeEnum.valueOf(code);
            return imageTypeRepository.findByType(typeEnum).stream().findFirst();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
