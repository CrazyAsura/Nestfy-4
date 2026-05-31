package com.example.backend.module.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.adapter.out.persistence.adapters.SuperAdminPersistenceAdapter;
import com.example.backend.module.domain.models.SuperAdmin;

@Service
public class SuperAdminService {

    private final SuperAdminPersistenceAdapter superAdminPersistenceAdapter;

    @Autowired
    public SuperAdminService(SuperAdminPersistenceAdapter superAdminPersistenceAdapter) {
        this.superAdminPersistenceAdapter = superAdminPersistenceAdapter;
    }

    public SuperAdmin createSuperAdmin(SuperAdmin superAdmin) {
        if (superAdmin == null) {
            throw new IllegalArgumentException("SuperAdmin cannot be null");
        }
        return superAdminPersistenceAdapter.save(superAdmin);
    }

    public SuperAdmin getSuperAdmin(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return superAdminPersistenceAdapter.findById(id).orElse(null);
    }

    public SuperAdmin updateSuperAdmin(SuperAdmin superAdmin) {
        if (superAdmin == null) {
            throw new IllegalArgumentException("SuperAdmin cannot be null");
        }
        return superAdminPersistenceAdapter.save(superAdmin);
    }

    public void deleteSuperAdmin(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        superAdminPersistenceAdapter.deleteById(id);
    }

    public Optional<SuperAdmin> findByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("email cannot be null");
        }
        return superAdminPersistenceAdapter.findByEmail(email);
    }

    public Optional<SuperAdmin> findByCpf(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("cpf cannot be null");
        }
        return superAdminPersistenceAdapter.findByCpf(cpf);
    }

    public List<SuperAdmin> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return superAdminPersistenceAdapter.findByActive(active);
    }

    public Optional<SuperAdmin> findByUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("username cannot be null");
        }
        return superAdminPersistenceAdapter.findByUsername(username);
    }
}
