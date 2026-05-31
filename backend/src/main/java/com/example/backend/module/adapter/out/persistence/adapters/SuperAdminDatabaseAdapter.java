package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.adapter.out.persistence.repositories.SuperAdminRepository;
import com.example.backend.module.domain.models.SuperAdmin;
import com.example.backend.module.domain.ports.out.ISuperAdminRepositoryPortOut;

@Component
public class SuperAdminDatabaseAdapter implements ISuperAdminRepositoryPortOut {

    @Autowired
    private SuperAdminRepository superAdminRepository;

    @Override
    public Optional<SuperAdmin> findByCpf(String cpf) {
        return superAdminRepository.findByCpf(cpf);
    }

    @Override
    public SuperAdmin save(SuperAdmin superAdmin) {
        return superAdminRepository.save(superAdmin);
    }

    @Override
    public Optional<SuperAdmin> findById(Long id) {
        return superAdminRepository.findById(id);
    }

    @Override
    public Iterable<SuperAdmin> findAll() {
        return superAdminRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        superAdminRepository.deleteById(id);
    }

    @Override
    public Optional<SuperAdmin> findByUsername(String username) {
        return superAdminRepository.findByUsername(username);
    }

    @Override
    public Optional<SuperAdmin> findByEmail(String email) {
        return superAdminRepository.findByEmail(email);
    }

    @Override
    public List<SuperAdmin> findByActive(Boolean active) {
        return superAdminRepository.findByActive(active);
    }
}
