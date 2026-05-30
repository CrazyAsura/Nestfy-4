package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.Sailor;

@Repository
public interface SailorRepository extends JpaRepository<Sailor, Long> {

    public List<Sailor> findByName(String name);

    public Optional<Sailor> findByEmail(String email);

    public Optional<Sailor> findByCpf(String cpf);

    public Optional<Sailor> findByCnpj(String cnpj);

    public List<Sailor> findByActive(Boolean active);
}
