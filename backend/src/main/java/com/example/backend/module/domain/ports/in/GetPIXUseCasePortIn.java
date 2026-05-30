package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.PIX;

public interface GetPIXUseCasePortIn {
    PIX execute(Long id);
}
