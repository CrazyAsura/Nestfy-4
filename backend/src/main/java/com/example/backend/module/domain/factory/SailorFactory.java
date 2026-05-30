package com.example.backend.module.domain.factory;

import com.example.backend.module.domain.models.Sailor;
import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.models.Address;
import com.example.backend.module.domain.factory.interfaces.ISailorFactory;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class SailorFactory implements ISailorFactory {

    @Override
    public Sailor createSailor(Long id, String name, String email, String password, String cpf, String cnpj, TypeUser type, Phone phone, Address address, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Sailor(id, name, email, password, cpf, cnpj, type, phone, address, active, createdAt, updatedAt);
    }
}
