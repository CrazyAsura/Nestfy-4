package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Client;
import com.example.backend.module.domain.ports.in.UpdateClientUseCasePortIn;
import com.example.backend.module.domain.ports.out.IClientRepositoryPortOut;

public class UpdateClientUseCase implements UpdateClientUseCasePortIn {
    private final IClientRepositoryPortOut clientRepositoryPortOut;

    public UpdateClientUseCase(IClientRepositoryPortOut clientRepositoryPortOut) {
        this.clientRepositoryPortOut = clientRepositoryPortOut;
    }

    @Override
    public Client execute(Client client) {
        return clientRepositoryPortOut.save(client);
    }
}

