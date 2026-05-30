package com.example.backend.module.domain.ports.out;

import java.util.List;

import com.example.backend.module.domain.models.Category;

public interface ICategoryRepositoryPortOut extends IRepositoryPortOut<Category, Long> {

    public List<Category> findByName(String name);
    public List<Category> findByActive(Boolean active);

}
