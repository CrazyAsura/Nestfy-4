package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Image;

public interface GetImageUseCasePortIn {
    Image execute(Long id);
}
