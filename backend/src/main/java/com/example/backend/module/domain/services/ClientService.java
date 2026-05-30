package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Client;
import com.example.backend.module.domain.ports.out.IClientRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateClientUseCase;
import com.example.backend.module.domain.usecases.DeleteClientUseCase;
import com.example.backend.module.domain.usecases.GetClientUseCase;
import com.example.backend.module.domain.usecases.UpdateClientUseCase;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final CreateClientUseCase createClientUseCase;
    private final GetClientUseCase getClientUseCase;
    private final UpdateClientUseCase updateClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;

    public ClientService(IClientRepositoryPortOut clientRepositoryPortOut) {
        this.createClientUseCase = new CreateClientUseCase(clientRepositoryPortOut);
        this.getClientUseCase = new GetClientUseCase(clientRepositoryPortOut);
        this.updateClientUseCase = new UpdateClientUseCase(clientRepositoryPortOut);
        this.deleteClientUseCase = new DeleteClientUseCase(clientRepositoryPortOut);
    }

    public Client createClient(Client client) {
        return createClientUseCase.execute(client);
    }

    public Client getClient(Long id) {
        return getClientUseCase.execute(id);
    }

    public Client updateClient(Client client) {
        return updateClientUseCase.execute(client);
    }

    public void deleteClient(Long id) {
        deleteClientUseCase.execute(id);
    }
}
