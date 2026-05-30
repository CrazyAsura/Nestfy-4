package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.adapter.out.persistence.repositories.SailorRepository;
import com.example.backend.module.domain.models.Sailor;
import com.example.backend.module.domain.ports.out.ISailorRepositoryPortOut;

@Component
public class SailorPersistenceAdapter implements ISailorRepositoryPortOut {

    @Autowired
    private SailorRepository sailorRepository;

    @Override
    public Sailor save(Sailor sailor) {
        return sailorRepository.save(sailor);
    }

    @Override
    public Optional<Sailor> findById(Long id) {
        return sailorRepository.findById(id);
    }

    @Override
    public Iterable<Sailor> findAll() {
        return sailorRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        sailorRepository.deleteById(id);
    }

    @Override
    public Optional<Sailor> findByEmail(String email) {
        return sailorRepository.findByEmail(email);
    }

    @Override
    public Optional<Sailor> findByCpf(String cpf) {
        return sailorRepository.findByCpf(cpf);
    }

    @Override
    public Optional<Sailor> findByCnpj(String cnpj) {
        return sailorRepository.findByCnpj(cnpj);
    }

    @Override
    public List<Sailor> findByType(String type) {
        return sailorRepository.findAll().stream()
                .filter(s -> s.getType() != null && s.getType().getType() != null && s.getType().getType().name().equalsIgnoreCase(type))
                .toList();
    }

    @Override
    public List<Sailor> findByActive(Boolean active) {
        return sailorRepository.findByActive(active);
    }
}
