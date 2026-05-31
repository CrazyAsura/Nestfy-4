package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class AdminPersistenceAdapter {

    private final CreateAdminUseCase createAdminUseCase;
    private final GetAdminUseCase getAdminUseCase;
    private final UpdateAdminUseCase updateAdminUseCase;
    private final DeleteAdminUseCase deleteAdminUseCase;
    private final IAdminRepositoryPortOut adminRepositoryPortOut;

    @Autowired
    public AdminPersistenceAdapter(CreateAdminUseCase createAdminUseCase,
            GetAdminUseCase getAdminUseCase,
            UpdateAdminUseCase updateAdminUseCase,
            DeleteAdminUseCase deleteAdminUseCase,
            IAdminRepositoryPortOut adminRepositoryPortOut) {
        this.createAdminUseCase = createAdminUseCase;
        this.getAdminUseCase = getAdminUseCase;
        this.updateAdminUseCase = updateAdminUseCase;
        this.deleteAdminUseCase = deleteAdminUseCase;
        this.adminRepositoryPortOut = adminRepositoryPortOut;
    }

    public Optional<Admin> findById(Long id) {
        return Optional.ofNullable(getAdminUseCase.execute(id));
    }

    public Iterable<Admin> findAll() {
        return adminRepositoryPortOut.findAll();
    }

    public Admin save(Admin entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createAdminUseCase.execute(entity);
        } else {
            return updateAdminUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteAdminUseCase.execute(id);
    }
    public Optional<Admin> findByEmail(String email) {
        return adminRepositoryPortOut.findByEmail(email);
    }

    public List<Admin> findByActive(Boolean active) {
        return adminRepositoryPortOut.findByActive(active);
    }
}
