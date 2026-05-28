package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.Client;

public interface ClientRepositoryPortOut extends IRepositoryPortOut<Client, Long> {

    public Optional<Client> findByEmail(String email);

    public Optional<Client> findByCpf(String cpf);

    public List<Client> findByActive(Boolean active);
}
