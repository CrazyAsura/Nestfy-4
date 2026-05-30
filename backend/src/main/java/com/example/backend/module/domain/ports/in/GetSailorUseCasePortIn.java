package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Sailor;

public interface GetSailorUseCasePortIn {
    Sailor execute(Long id);
}
