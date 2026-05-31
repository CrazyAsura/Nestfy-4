package com.example.backend.module.domain.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.adapter.out.persistence.adapters.ClientPersistenceAdapter;

@Service
public class ClientService {

    private final ClientPersistenceAdapter clientPersistenceAdapter;

    @Autowired
    public ClientService(ClientPersistenceAdapter clientPersistenceAdapter) {
        this.clientPersistenceAdapter = clientPersistenceAdapter;
    }

    public Client createClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        return clientPersistenceAdapter.save(client);
    }

    public Client getClient(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return clientPersistenceAdapter.findById(id).orElse(null);
    }

    public Client updateClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        return clientPersistenceAdapter.save(client);
    }

    public void deleteClient(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        clientPersistenceAdapter.deleteById(id);
    }
    public Optional<Client> findByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("email cannot be null");
        }
        return clientPersistenceAdapter.findByEmail(email);
    }

    public Optional<Client> findByCpf(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("cpf cannot be null");
        }
        return clientPersistenceAdapter.findByCpf(cpf);
    }

    public List<Client> findByActive(Boolean active) {
        if (active == null) {
            throw new IllegalArgumentException("active cannot be null");
        }
        return clientPersistenceAdapter.findByActive(active);
    }
}
