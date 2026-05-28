package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.Admin;

public interface AdminRepositoryPortOut extends IRepositoryPortOut<Admin, Long> {
    
    public Optional<Admin> findByEmail(String email);
    public List<Admin> findByActive(Boolean active);
}
