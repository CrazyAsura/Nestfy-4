package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Category;
import com.example.backend.module.domain.ports.in.GetCategoryUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICategoryRepositoryPortOut;

@Component
public class GetCategoryUseCase implements GetCategoryUseCasePortIn {
    private final ICategoryRepositoryPortOut categoryRepositoryPortOut;

    public GetCategoryUseCase(ICategoryRepositoryPortOut categoryRepositoryPortOut) {
        this.categoryRepositoryPortOut = categoryRepositoryPortOut;
    }

    @Override
    public Category execute(Long id) {
        return categoryRepositoryPortOut.findById(id).orElse(null);
    }
}

