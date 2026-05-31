package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteCategoryUseCasePortIn;
import com.example.backend.module.domain.ports.out.ICategoryRepositoryPortOut;

@Component
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

