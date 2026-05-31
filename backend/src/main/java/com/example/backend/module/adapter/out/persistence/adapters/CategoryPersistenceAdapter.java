package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class CategoryPersistenceAdapter {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final GetCategoryUseCase getCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;
    private final ICategoryRepositoryPortOut categoryRepositoryPortOut;

    @Autowired
    public CategoryPersistenceAdapter(CreateCategoryUseCase createCategoryUseCase,
            GetCategoryUseCase getCategoryUseCase,
            UpdateCategoryUseCase updateCategoryUseCase,
            DeleteCategoryUseCase deleteCategoryUseCase,
            ICategoryRepositoryPortOut categoryRepositoryPortOut) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.getCategoryUseCase = getCategoryUseCase;
        this.updateCategoryUseCase = updateCategoryUseCase;
        this.deleteCategoryUseCase = deleteCategoryUseCase;
        this.categoryRepositoryPortOut = categoryRepositoryPortOut;
    }

    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(getCategoryUseCase.execute(id));
    }

    public Iterable<Category> findAll() {
        return categoryRepositoryPortOut.findAll();
    }

    public Category save(Category entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createCategoryUseCase.execute(entity);
        } else {
            return updateCategoryUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteCategoryUseCase.execute(id);
    }
    public List<Category> findByName(String name) {
        return categoryRepositoryPortOut.findByName(name);
    }

    public List<Category> findByActive(Boolean active) {
        return categoryRepositoryPortOut.findByActive(active);
    }
}
