package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class ClientPersistenceAdapter {

    private final CreateClientUseCase createClientUseCase;
    private final GetClientUseCase getClientUseCase;
    private final UpdateClientUseCase updateClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final IClientRepositoryPortOut clientRepositoryPortOut;

    @Autowired
    public ClientPersistenceAdapter(CreateClientUseCase createClientUseCase,
            GetClientUseCase getClientUseCase,
            UpdateClientUseCase updateClientUseCase,
            DeleteClientUseCase deleteClientUseCase,
            IClientRepositoryPortOut clientRepositoryPortOut) {
        this.createClientUseCase = createClientUseCase;
        this.getClientUseCase = getClientUseCase;
        this.updateClientUseCase = updateClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
        this.clientRepositoryPortOut = clientRepositoryPortOut;
    }

    public Optional<Client> findById(Long id) {
        return Optional.ofNullable(getClientUseCase.execute(id));
    }

    public Iterable<Client> findAll() {
        return clientRepositoryPortOut.findAll();
    }

    public Client save(Client entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createClientUseCase.execute(entity);
        } else {
            return updateClientUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteClientUseCase.execute(id);
    }
    public Optional<Client> findByEmail(String email) {
        return clientRepositoryPortOut.findByEmail(email);
    }

    public Optional<Client> findByCpf(String cpf) {
        return clientRepositoryPortOut.findByCpf(cpf);
    }

    public List<Client> findByActive(Boolean active) {
        return clientRepositoryPortOut.findByActive(active);
    }
}
