package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.Sailor;
import com.example.backend.module.domain.ports.out.ISailorRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateSailorUseCase;
import com.example.backend.module.domain.usecases.DeleteSailorUseCase;
import com.example.backend.module.domain.usecases.GetSailorUseCase;
import com.example.backend.module.domain.usecases.UpdateSailorUseCase;

@Component
public class SailorPersistenceAdapter {

    private final CreateSailorUseCase createSailorUseCase;
    private final GetSailorUseCase getSailorUseCase;
    private final UpdateSailorUseCase updateSailorUseCase;
    private final DeleteSailorUseCase deleteSailorUseCase;
    private final ISailorRepositoryPortOut sailorRepositoryPortOut;

    @Autowired
    public SailorPersistenceAdapter(CreateSailorUseCase createSailorUseCase,
            GetSailorUseCase getSailorUseCase,
            UpdateSailorUseCase updateSailorUseCase,
            DeleteSailorUseCase deleteSailorUseCase,
            ISailorRepositoryPortOut sailorRepositoryPortOut) {
        this.createSailorUseCase = createSailorUseCase;
        this.getSailorUseCase = getSailorUseCase;
        this.updateSailorUseCase = updateSailorUseCase;
        this.deleteSailorUseCase = deleteSailorUseCase;
        this.sailorRepositoryPortOut = sailorRepositoryPortOut;
    }

    public Optional<Sailor> findById(Long id) {
        return Optional.ofNullable(getSailorUseCase.execute(id));
    }

    public Iterable<Sailor> findAll() {
        return sailorRepositoryPortOut.findAll();
    }

    public Sailor save(Sailor entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createSailorUseCase.execute(entity);
        } else {
            return updateSailorUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteSailorUseCase.execute(id);
    }

    public Optional<Sailor> findByEmail(String email) {
        return sailorRepositoryPortOut.findByEmail(email);
    }

    public Optional<Sailor> findByCpf(String cpf) {
        return sailorRepositoryPortOut.findByCpf(cpf);
    }

    public Optional<Sailor> findByCnpj(String cnpj) {
        return sailorRepositoryPortOut.findByCnpj(cnpj);
    }

    public List<Sailor> findByType(String type) {
        return sailorRepositoryPortOut.findByType(type);
    }

    public List<Sailor> findByActive(Boolean active) {
        return sailorRepositoryPortOut.findByActive(active);
    }
}
