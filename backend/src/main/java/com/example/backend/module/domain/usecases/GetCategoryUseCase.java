package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Category;
import com.example.backend.module.domain.ports.in.GetCategoryUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICategoryRepositoryPortOut;

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

