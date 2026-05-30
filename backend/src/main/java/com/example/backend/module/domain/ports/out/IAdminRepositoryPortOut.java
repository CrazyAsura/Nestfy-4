package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.Admin;

public interface IAdminRepositoryPortOut extends IRepositoryPortOut<Admin, Long> {

    Optional<Admin> findByEmail(String email);

    List<Admin> findByActive(Boolean active);

    Iterable<Admin> findAll();
}

