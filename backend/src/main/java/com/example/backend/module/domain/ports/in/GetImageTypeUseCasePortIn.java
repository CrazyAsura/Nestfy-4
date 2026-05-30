package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.ImageType;

public interface GetImageTypeUseCasePortIn {
    ImageType execute(Long id);
}
