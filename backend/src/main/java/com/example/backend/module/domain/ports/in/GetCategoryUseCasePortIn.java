package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Category;

public interface GetCategoryUseCasePortIn {
    Category execute(Long id);
}
