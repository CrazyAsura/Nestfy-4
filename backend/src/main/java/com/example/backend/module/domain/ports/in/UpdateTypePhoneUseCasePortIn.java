package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.TypePhone;

public interface UpdateTypePhoneUseCasePortIn {
    TypePhone execute(TypePhone typePhone);
}
