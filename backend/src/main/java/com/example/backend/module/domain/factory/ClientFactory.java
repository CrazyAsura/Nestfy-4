package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.Client;
import com.example.backend.module.domain.models.User;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.factory.interfaces.IClientFactory;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class ClientFactory implements IClientFactory {

    @Override
    public Client createClient(Long id, String name, String email, String password, String cpf, String cnpj, TypeUser type, Phone phone, Address address, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        User user = new User(id, name, email, password, cpf, cnpj, type, phone, address, active, createdAt, updatedAt);
        return new Client(id, user, type, active);
    }
}
