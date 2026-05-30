package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.SuperAdmin;
import com.example.backend.module.domain.ports.out.ISuperAdminRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateSuperAdminUseCase;
import com.example.backend.module.domain.usecases.DeleteSuperAdminUseCase;
import com.example.backend.module.domain.usecases.GetSuperAdminUseCase;
import com.example.backend.module.domain.usecases.UpdateSuperAdminUseCase;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminService {
    private final CreateSuperAdminUseCase createSuperAdminUseCase;
    private final GetSuperAdminUseCase getSuperAdminUseCase;
    private final UpdateSuperAdminUseCase updateSuperAdminUseCase;
    private final DeleteSuperAdminUseCase deleteSuperAdminUseCase;

    public SuperAdminService(ISuperAdminRepositoryPortOut superAdminRepositoryPortOut) {
        this.createSuperAdminUseCase = new CreateSuperAdminUseCase(superAdminRepositoryPortOut);
        this.getSuperAdminUseCase = new GetSuperAdminUseCase(superAdminRepositoryPortOut);
        this.updateSuperAdminUseCase = new UpdateSuperAdminUseCase(superAdminRepositoryPortOut);
        this.deleteSuperAdminUseCase = new DeleteSuperAdminUseCase(superAdminRepositoryPortOut);
    }

    public SuperAdmin createSuperAdmin(SuperAdmin superadmin) {
        return createSuperAdminUseCase.execute(superadmin);
    }

    public SuperAdmin getSuperAdmin(Long id) {
        return getSuperAdminUseCase.execute(id);
    }

    public SuperAdmin updateSuperAdmin(SuperAdmin superadmin) {
        return updateSuperAdminUseCase.execute(superadmin);
    }

    public void deleteSuperAdmin(Long id) {
        deleteSuperAdminUseCase.execute(id);
    }
}
