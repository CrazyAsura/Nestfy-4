package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.TypePhone;

public interface GetTypePhoneUseCasePortIn {
    TypePhone execute(Long id);
}
