package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.factory.interfaces.IPIXFactory;
import com.example.backend.module.domain.models.PIX;
import com.example.backend.module.domain.models.TypeKeyPixEnum;
import org.springframework.stereotype.Component;

@Component
public class PIXFactory implements IPIXFactory {

    @Override
    public PIX createPIX(Long id, String chavePix, TypeKeyPixEnum typeKeyPix, String description, Boolean active) {
        return new PIX(id, chavePix, typeKeyPix, description, active);
    }

    @Override
    public PIX createEmptyPIX() {
        return new PIX();
    }
}
