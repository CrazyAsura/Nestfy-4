package com.example.backend.module.domain.ports.out;

import java.util.Optional;

import com.example.backend.module.domain.models.ImageType;

public interface ImageTypeRepositoryPortOut extends IRepositoryPortOut<ImageType, Long> {

    public Optional<ImageType> findByCode(String code);
}
