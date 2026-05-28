package com.example.backend.module.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.backend.module.domain.models.User;

public interface IUserRepositoryPortOut extends IRepositoryPortOut<User, Long> {

    public Optional<User> findByEmail(String email);

    public Optional<User> findByCpf(String cpf);

    public Optional<User> findByCnpj(String cnpj);

    public List<User> findByType(String type);

    public List<User> findByActive(Boolean active);

}