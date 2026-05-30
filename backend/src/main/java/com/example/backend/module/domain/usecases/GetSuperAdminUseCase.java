package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.SuperAdmin;
import com.example.backend.module.domain.ports.in.GetSuperAdminUseCasePortIn;
import com.example.backend.module.domain.ports.out.ISuperAdminRepositoryPortOut;

public class GetSuperAdminUseCase implements GetSuperAdminUseCasePortIn {
    private final ISuperAdminRepositoryPortOut superAdminRepositoryPortOut;

    public GetSuperAdminUseCase(ISuperAdminRepositoryPortOut superAdminRepositoryPortOut) {
        this.superAdminRepositoryPortOut = superAdminRepositoryPortOut;
    }

    @Override
    public SuperAdmin execute(Long id) {
        return superAdminRepositoryPortOut.findById(id).orElse(null);
    }
}

