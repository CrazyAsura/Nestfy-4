package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.SuperAdmin;
import com.example.backend.module.domain.ports.in.UpdateSuperAdminUseCasePortIn;
import com.example.backend.module.domain.ports.out.ISuperAdminRepositoryPortOut;

@Component
public class UpdateSuperAdminUseCase implements UpdateSuperAdminUseCasePortIn {
    private final ISuperAdminRepositoryPortOut superAdminRepositoryPortOut;

    public UpdateSuperAdminUseCase(ISuperAdminRepositoryPortOut superAdminRepositoryPortOut) {
        this.superAdminRepositoryPortOut = superAdminRepositoryPortOut;
    }

    @Override
    public SuperAdmin execute(SuperAdmin superAdmin) {
        return superAdminRepositoryPortOut.save(superAdmin);
    }
}

