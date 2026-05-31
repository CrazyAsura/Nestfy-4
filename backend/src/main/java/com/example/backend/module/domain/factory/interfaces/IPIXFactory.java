package com.example.backend.module.domain.factory.interfaces;

import com.example.backend.module.domain.models.PIX;
import com.example.backend.module.domain.models.TypeKeyPixEnum;

public interface IPIXFactory {

    PIX createPIX(Long id, String chavePix, TypeKeyPixEnum typeKeyPix, String description, Boolean active);

    PIX createEmptyPIX();
}
