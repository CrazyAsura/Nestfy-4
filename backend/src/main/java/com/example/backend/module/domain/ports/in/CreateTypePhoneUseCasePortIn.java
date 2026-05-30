package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.TypePhone;

public interface CreateTypePhoneUseCasePortIn {
    TypePhone execute(TypePhone typePhone);
}
