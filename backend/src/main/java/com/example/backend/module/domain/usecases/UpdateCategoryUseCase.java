package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Category;
import com.example.backend.module.domain.ports.in.UpdateCategoryUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICategoryRepositoryPortOut;

@Component
public class UpdateCategoryUseCase implements UpdateCategoryUseCasePortIn {
    private final ICategoryRepositoryPortOut categoryRepositoryPortOut;

    public UpdateCategoryUseCase(ICategoryRepositoryPortOut categoryRepositoryPortOut) {
        this.categoryRepositoryPortOut = categoryRepositoryPortOut;
    }

    @Override
    public Category execute(Category category) {
        return categoryRepositoryPortOut.save(category);
    }
}

