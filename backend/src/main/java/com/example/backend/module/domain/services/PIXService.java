package com.example.backend.module.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.adapter.out.persistence.adapters.PIXPersistenceAdapter;
import com.example.backend.module.domain.models.PIX;

@Service
public class PIXService {

    private final PIXPersistenceAdapter pixPersistenceAdapter;

    @Autowired
    public PIXService(PIXPersistenceAdapter pixPersistenceAdapter) {
        this.pixPersistenceAdapter = pixPersistenceAdapter;
    }

    public PIX createPIX(PIX pix) {
        if (pix == null) {
            throw new IllegalArgumentException("PIX cannot be null");
        }
        return pixPersistenceAdapter.save(pix);
    }

    public PIX getPIX(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return pixPersistenceAdapter.findById(id).orElse(null);
    }

    public PIX updatePIX(PIX pix) {
        if (pix == null) {
            throw new IllegalArgumentException("PIX cannot be null");
        }
        return pixPersistenceAdapter.save(pix);
    }

    public void deletePIX(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        pixPersistenceAdapter.deleteById(id);
    }

    public Optional<PIX> findByKey(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return pixPersistenceAdapter.findByKey(key);
    }

    public List<PIX> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("Active cannot be null");
        }
        return pixPersistenceAdapter.findByActive(active);
    }

    public List<PIX> findByClientId(Long clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("ClientId cannot be null");
        }
        return pixPersistenceAdapter.findByClientId(clientId);
    }
}
