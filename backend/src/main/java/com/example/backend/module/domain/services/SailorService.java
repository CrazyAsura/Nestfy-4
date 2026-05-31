package com.example.backend.module.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.adapter.out.persistence.adapters.SailorPersistenceAdapter;
import com.example.backend.module.domain.models.Sailor;

@Service
public class SailorService {

    private final SailorPersistenceAdapter sailorPersistenceAdapter;

    @Autowired
    public SailorService(SailorPersistenceAdapter sailorPersistenceAdapter) {
        this.sailorPersistenceAdapter = sailorPersistenceAdapter;
    }

    public Sailor createSailor(Sailor sailor) {
        if (sailor == null) {
            throw new IllegalArgumentException("Sailor cannot be null");
        }
        return sailorPersistenceAdapter.save(sailor);
    }

    public Sailor getSailor(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return sailorPersistenceAdapter.findById(id).orElse(null);
    }

    public Sailor updateSailor(Sailor sailor) {
        if (sailor == null) {
            throw new IllegalArgumentException("Sailor cannot be null");
        }
        return sailorPersistenceAdapter.save(sailor);
    }

    public void deleteSailor(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        sailorPersistenceAdapter.deleteById(id);
    }

    public Optional<Sailor> findByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("email cannot be null");
        }
        return sailorPersistenceAdapter.findByEmail(email);
    }

    public Optional<Sailor> findByCpf(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("cpf cannot be null");
        }
        return sailorPersistenceAdapter.findByCpf(cpf);
    }

    public Optional<Sailor> findByCnpj(String cnpj) {
        if (cnpj == null) {
            throw new IllegalArgumentException("cnpj cannot be null");
        }
        return sailorPersistenceAdapter.findByCnpj(cnpj);
    }

    public List<Sailor> findByType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        return sailorPersistenceAdapter.findByType(type);
    }

    public List<Sailor> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return sailorPersistenceAdapter.findByActive(active);
    }
}
