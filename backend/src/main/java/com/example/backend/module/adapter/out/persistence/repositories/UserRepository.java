package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByName(String name);

    public List<User> findByEmail(String email);

    public List<User> findByCpf(String cpf);

    public List<User> findByCnpj(String cnpj);

    public List<User> findByActive(Boolean active);
}
