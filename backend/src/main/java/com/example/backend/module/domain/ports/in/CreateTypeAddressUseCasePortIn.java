package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.TypeAddress;

public interface CreateTypeAddressUseCasePortIn {
    TypeAddress execute(TypeAddress typeAddress);
}
