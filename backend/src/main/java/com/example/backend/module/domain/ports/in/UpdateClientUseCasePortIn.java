package com.example.backend.module.domain.ports.in;

import com.example.backend.module.domain.models.Client;

public interface UpdateClientUseCasePortIn {
    Client execute(Client client);
}
