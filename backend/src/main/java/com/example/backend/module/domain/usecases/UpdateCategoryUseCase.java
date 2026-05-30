package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Category;
import com.example.backend.module.domain.ports.in.UpdateCategoryUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICategoryRepositoryPortOut;

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

