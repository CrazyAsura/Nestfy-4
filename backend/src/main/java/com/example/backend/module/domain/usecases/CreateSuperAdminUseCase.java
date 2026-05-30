package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.SuperAdmin;
import com.example.backend.module.domain.ports.in.CreateSuperAdminUseCasePortIn;
import com.example.backend.module.domain.ports.out.ISuperAdminRepositoryPortOut;

public class CreateSuperAdminUseCase implements CreateSuperAdminUseCasePortIn {
    private final ISuperAdminRepositoryPortOut superAdminRepositoryPortOut;

    public CreateSuperAdminUseCase(ISuperAdminRepositoryPortOut superAdminRepositoryPortOut) {
        this.superAdminRepositoryPortOut = superAdminRepositoryPortOut;
    }

    @Override
    public SuperAdmin execute(SuperAdmin superAdmin) {
        return superAdminRepositoryPortOut.save(superAdmin);
    }
}



