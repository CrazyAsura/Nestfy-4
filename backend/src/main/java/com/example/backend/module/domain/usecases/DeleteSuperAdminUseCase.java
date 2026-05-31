package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteSuperAdminUseCasePortIn;
import com.example.backend.module.domain.ports.out.ISuperAdminRepositoryPortOut;

@Component
public class DeleteSuperAdminUseCase implements DeleteSuperAdminUseCasePortIn {
    private final ISuperAdminRepositoryPortOut superAdminRepositoryPortOut;

    public DeleteSuperAdminUseCase(ISuperAdminRepositoryPortOut superAdminRepositoryPortOut) {
        this.superAdminRepositoryPortOut = superAdminRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        superAdminRepositoryPortOut.deleteById(id);
    }
}

