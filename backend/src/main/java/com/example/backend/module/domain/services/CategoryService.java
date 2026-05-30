package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Category;
import com.example.backend.module.domain.ports.out.ICategoryRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateCategoryUseCase;
import com.example.backend.module.domain.usecases.DeleteCategoryUseCase;
import com.example.backend.module.domain.usecases.GetCategoryUseCase;
import com.example.backend.module.domain.usecases.UpdateCategoryUseCase;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CreateCategoryUseCase createCategoryUseCase;
    private final GetCategoryUseCase getCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;

    public CategoryService(ICategoryRepositoryPortOut categoryRepositoryPortOut) {
        this.createCategoryUseCase = new CreateCategoryUseCase(categoryRepositoryPortOut);
        this.getCategoryUseCase = new GetCategoryUseCase(categoryRepositoryPortOut);
        this.updateCategoryUseCase = new UpdateCategoryUseCase(categoryRepositoryPortOut);
        this.deleteCategoryUseCase = new DeleteCategoryUseCase(categoryRepositoryPortOut);
    }

    public Category createCategory(Category category) {
        return createCategoryUseCase.execute(category);
    }

    public Category getCategory(Long id) {
        return getCategoryUseCase.execute(id);
    }

    public Category updateCategory(Category category) {
        return updateCategoryUseCase.execute(category);
    }

    public void deleteCategory(Long id) {
        deleteCategoryUseCase.execute(id);
    }
}
