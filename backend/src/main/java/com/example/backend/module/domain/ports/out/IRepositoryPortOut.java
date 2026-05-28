package com.example.backend.module.domain.ports.out;

import java.util.Optional;

public interface IRepositoryPortOut<T, ID> {

    Optional<T> findById(ID id);

    Iterable<T> findAll();

    T save(T entity);

    void deleteById(ID id);

}
