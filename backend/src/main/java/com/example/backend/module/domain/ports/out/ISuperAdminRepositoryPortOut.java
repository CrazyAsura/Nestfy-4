package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.SuperAdmin;

public interface ISuperAdminRepositoryPortOut extends IRepositoryPortOut<SuperAdmin, Long> {

    public Optional<SuperAdmin> findByEmail(String email);

    public Optional<SuperAdmin> findByCpf(String cpf);

    public List<SuperAdmin> findByActive(Boolean active);

    public Optional<SuperAdmin> findByUsername(String username);
    

}


