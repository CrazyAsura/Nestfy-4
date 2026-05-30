package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Phone;

public interface CreatePhoneUseCasePortIn {
    Phone execute(Phone phone);
}
