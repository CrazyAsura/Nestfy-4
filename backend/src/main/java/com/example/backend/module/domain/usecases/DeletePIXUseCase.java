package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeletePIXUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPIXRepositoryPortOut;

public class DeletePIXUseCase implements DeletePIXUseCasePortIn {
    private final IPIXRepositoryPortOut pixRepositoryPortOut;

    public DeletePIXUseCase(IPIXRepositoryPortOut pixRepositoryPortOut) {
        this.pixRepositoryPortOut = pixRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        pixRepositoryPortOut.deleteById(id);
    }
}

