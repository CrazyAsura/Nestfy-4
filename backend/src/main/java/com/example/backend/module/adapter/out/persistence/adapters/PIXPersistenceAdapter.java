package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.PIX;
import com.example.backend.module.domain.ports.out.IPIXRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreatePIXUseCase;
import com.example.backend.module.domain.usecases.DeletePIXUseCase;
import com.example.backend.module.domain.usecases.GetPIXUseCase;
import com.example.backend.module.domain.usecases.UpdatePIXUseCase;

@Component
public class PIXPersistenceAdapter {

    private final CreatePIXUseCase createPIXUseCase;
    private final GetPIXUseCase getPIXUseCase;
    private final UpdatePIXUseCase updatePIXUseCase;
    private final DeletePIXUseCase deletePIXUseCase;
    private final IPIXRepositoryPortOut pixRepositoryPortOut;

    @Autowired
    public PIXPersistenceAdapter(CreatePIXUseCase createPIXUseCase,
            GetPIXUseCase getPIXUseCase,
            UpdatePIXUseCase updatePIXUseCase,
            DeletePIXUseCase deletePIXUseCase,
            IPIXRepositoryPortOut pixRepositoryPortOut) {
        this.createPIXUseCase = createPIXUseCase;
        this.getPIXUseCase = getPIXUseCase;
        this.updatePIXUseCase = updatePIXUseCase;
        this.deletePIXUseCase = deletePIXUseCase;
        this.pixRepositoryPortOut = pixRepositoryPortOut;
    }

    public Optional<PIX> findById(Long id) {
        return Optional.ofNullable(getPIXUseCase.execute(id));
    }

    public Iterable<PIX> findAll() {
        return pixRepositoryPortOut.findAll();
    }

    public PIX save(PIX entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createPIXUseCase.execute(entity);
        } else {
            return updatePIXUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deletePIXUseCase.execute(id);
    }

    public Optional<PIX> findByKey(String key) {
        return pixRepositoryPortOut.findByKey(key);
    }

    public List<PIX> findByActive(Boolean active) {
        return pixRepositoryPortOut.findByActive(active);
    }

    public List<PIX> findByClientId(Long clientId) {
        return pixRepositoryPortOut.findByClientId(clientId);
    }
}
