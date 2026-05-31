package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.adapter.out.persistence.repositories.*;

@Component
public class ClientDatabaseAdapter implements IClientRepositoryPortOut {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client save(Client entity) {
        return clientRepository.save(entity);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return clientRepository.findAll().stream()
                .filter(c -> c.getUser() != null && email.equals(c.getUser().getEmail()))
                .findFirst();
    }

    @Override
    public Optional<Client> findByCpf(String cpf) {
        return clientRepository.findAll().stream()
                .filter(c -> c.getUser() != null && cpf.equals(c.getUser().getCpf()))
                .findFirst();
    }

    @Override
    public List<Client> findByActive(Boolean active) {
        return clientRepository.findByActive(active);
    }
}
