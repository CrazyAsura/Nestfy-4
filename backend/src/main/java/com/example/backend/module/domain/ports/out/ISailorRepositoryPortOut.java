package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.Sailor;

public interface ISailorRepositoryPortOut extends IRepositoryPortOut<Sailor, Long> {

    public Optional<Sailor> findByEmail(String email);

    public Optional<Sailor> findByCpf(String cpf);

    public Optional<Sailor> findByCnpj(String cnpj);

    public List<Sailor> findByType(String type);

    public List<Sailor> findByActive(Boolean active);

}
