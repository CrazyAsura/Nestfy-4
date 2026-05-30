package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteCategoryUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICategoryRepositoryPortOut;

public class DeleteCategoryUseCase implements DeleteCategoryUseCasePortIn {
    private final ICategoryRepositoryPortOut categoryRepositoryPortOut;

    public DeleteCategoryUseCase(ICategoryRepositoryPortOut categoryRepositoryPortOut) {
        this.categoryRepositoryPortOut = categoryRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        categoryRepositoryPortOut.deleteById(id);
    }
}

