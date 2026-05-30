package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeleteClientUseCasePortIn;
import com.example.backend.module.domain.ports.out.IClientRepositoryPortOut;

public class DeleteClientUseCase implements DeleteClientUseCasePortIn {
    private final IClientRepositoryPortOut clientRepositoryPortOut;

    public DeleteClientUseCase(IClientRepositoryPortOut clientRepositoryPortOut) {
        this.clientRepositoryPortOut = clientRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        clientRepositoryPortOut.deleteById(id);
    }
}

