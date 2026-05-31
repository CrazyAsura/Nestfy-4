package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Client;
import com.example.backend.module.domain.ports.in.CreateClientUseCasePortIn;
import com.example.backend.module.domain.ports.out.IClientRepositoryPortOut;

@Component
public class CreateClientUseCase implements CreateClientUseCasePortIn {

    private final IClientRepositoryPortOut clientRepositoryPortOut;

    public CreateClientUseCase(IClientRepositoryPortOut clientRepositoryPortOut) {
        this.clientRepositoryPortOut = clientRepositoryPortOut;
    }

    @Override
    public Client execute(Client client) {
        return clientRepositoryPortOut.save(client);
    }
}



