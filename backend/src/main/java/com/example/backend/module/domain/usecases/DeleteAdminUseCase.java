package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteAdminUseCasePortIn;
import com.example.backend.module.domain.ports.out.IAdminRepositoryPortOut;

public class DeleteAdminUseCase implements DeleteAdminUseCasePortIn {
    private final IAdminRepositoryPortOut adminRepositoryPortOut;

    public DeleteAdminUseCase(IAdminRepositoryPortOut adminRepositoryPortOut) {
        this.adminRepositoryPortOut = adminRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        adminRepositoryPortOut.deleteById(id);
    }
}

