package com.example.backend.module.domain.ports.out;

import java.util.List;
import com.example.backend.module.domain.models.Image;

public interface ImageRepositoryPortOut extends IRepositoryPortOut<Image, Long> {

    public List<Image> findByActive(Boolean active);
}
