package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.Client;
import com.example.backend.module.domain.ports.in.GetClientUseCasePortIn;
import com.example.backend.module.domain.ports.out.IClientRepositoryPortOut;

@Component
public class GetClientUseCase implements GetClientUseCasePortIn {
    private final IClientRepositoryPortOut clientRepositoryPortOut;

    public GetClientUseCase(IClientRepositoryPortOut clientRepositoryPortOut) {
        this.clientRepositoryPortOut = clientRepositoryPortOut;
    }

    @Override
    public Client execute(Long id) {
        return clientRepositoryPortOut.findById(id).orElse(null);
    }
}

