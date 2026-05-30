package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Product;

public interface UpdateProductUseCasePortIn {
    Product execute(Product product);
}
