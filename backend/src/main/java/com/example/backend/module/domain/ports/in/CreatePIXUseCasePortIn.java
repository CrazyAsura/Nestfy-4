package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.PIX;

public interface CreatePIXUseCasePortIn {
    PIX execute(PIX pix);
}
