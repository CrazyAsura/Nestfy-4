package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.SuperAdmin;
import com.example.backend.module.domain.ports.out.ISuperAdminRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateSuperAdminUseCase;
import com.example.backend.module.domain.usecases.DeleteSuperAdminUseCase;
import com.example.backend.module.domain.usecases.GetSuperAdminUseCase;
import com.example.backend.module.domain.usecases.UpdateSuperAdminUseCase;

@Component
public class SuperAdminPersistenceAdapter {

    private final CreateSuperAdminUseCase createSuperAdminUseCase;
    private final GetSuperAdminUseCase getSuperAdminUseCase;
    private final UpdateSuperAdminUseCase updateSuperAdminUseCase;
    private final DeleteSuperAdminUseCase deleteSuperAdminUseCase;
    private final ISuperAdminRepositoryPortOut superAdminRepositoryPortOut;

    @Autowired
    public SuperAdminPersistenceAdapter(CreateSuperAdminUseCase createSuperAdminUseCase,
            GetSuperAdminUseCase getSuperAdminUseCase,
            UpdateSuperAdminUseCase updateSuperAdminUseCase,
            DeleteSuperAdminUseCase deleteSuperAdminUseCase,
            ISuperAdminRepositoryPortOut superAdminRepositoryPortOut) {
        this.createSuperAdminUseCase = createSuperAdminUseCase;
        this.getSuperAdminUseCase = getSuperAdminUseCase;
        this.updateSuperAdminUseCase = updateSuperAdminUseCase;
        this.deleteSuperAdminUseCase = deleteSuperAdminUseCase;
        this.superAdminRepositoryPortOut = superAdminRepositoryPortOut;
    }

    public Optional<SuperAdmin> findById(Long id) {
        return Optional.ofNullable(getSuperAdminUseCase.execute(id));
    }

    public Iterable<SuperAdmin> findAll() {
        return superAdminRepositoryPortOut.findAll();
    }

    public SuperAdmin save(SuperAdmin entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createSuperAdminUseCase.execute(entity);
        } else {
            return updateSuperAdminUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteSuperAdminUseCase.execute(id);
    }

    public Optional<SuperAdmin> findByEmail(String email) {
        return superAdminRepositoryPortOut.findByEmail(email);
    }

    public Optional<SuperAdmin> findByCpf(String cpf) {
        return superAdminRepositoryPortOut.findByCpf(cpf);
    }

    public List<SuperAdmin> findByActive(Boolean active) {
        return superAdminRepositoryPortOut.findByActive(active);
    }

    public Optional<SuperAdmin> findByUsername(String username) {
        return superAdminRepositoryPortOut.findByUsername(username);
    }
}
