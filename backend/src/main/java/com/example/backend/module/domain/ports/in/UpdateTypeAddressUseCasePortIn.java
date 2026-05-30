package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.TypeAddress;

public interface UpdateTypeAddressUseCasePortIn {
    TypeAddress execute(TypeAddress typeAddress);
}
