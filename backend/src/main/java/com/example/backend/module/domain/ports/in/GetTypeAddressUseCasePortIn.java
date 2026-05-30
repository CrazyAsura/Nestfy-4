package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.TypeAddress;

public interface GetTypeAddressUseCasePortIn {
    TypeAddress execute(Long id);
}
