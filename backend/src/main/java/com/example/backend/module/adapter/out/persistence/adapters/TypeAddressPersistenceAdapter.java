package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.TypeAddress;
import com.example.backend.module.domain.ports.out.ITypeAddressRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateTypeAddressUseCase;
import com.example.backend.module.domain.usecases.DeleteTypeAddressUseCase;
import com.example.backend.module.domain.usecases.GetTypeAddressUseCase;
import com.example.backend.module.domain.usecases.UpdateTypeAddressUseCase;

@Component
public class TypeAddressPersistenceAdapter {

    private final CreateTypeAddressUseCase createTypeAddressUseCase;
    private final GetTypeAddressUseCase getTypeAddressUseCase;
    private final UpdateTypeAddressUseCase updateTypeAddressUseCase;
    private final DeleteTypeAddressUseCase deleteTypeAddressUseCase;
    private final ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut;

    @Autowired
    public TypeAddressPersistenceAdapter(CreateTypeAddressUseCase createTypeAddressUseCase,
            GetTypeAddressUseCase getTypeAddressUseCase,
            UpdateTypeAddressUseCase updateTypeAddressUseCase,
            DeleteTypeAddressUseCase deleteTypeAddressUseCase,
            ITypeAddressRepositoryPortOut typeAddressRepositoryPortOut) {
        this.createTypeAddressUseCase = createTypeAddressUseCase;
        this.getTypeAddressUseCase = getTypeAddressUseCase;
        this.updateTypeAddressUseCase = updateTypeAddressUseCase;
        this.deleteTypeAddressUseCase = deleteTypeAddressUseCase;
        this.typeAddressRepositoryPortOut = typeAddressRepositoryPortOut;
    }

    public Optional<TypeAddress> findById(Long id) {
        return Optional.ofNullable(getTypeAddressUseCase.execute(id));
    }

    public Iterable<TypeAddress> findAll() {
        return typeAddressRepositoryPortOut.findAll();
    }

    public TypeAddress save(TypeAddress entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createTypeAddressUseCase.execute(entity);
        } else {
            return updateTypeAddressUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteTypeAddressUseCase.execute(id);
    }

    public Optional<TypeAddress> findByCode(String code) {
        return typeAddressRepositoryPortOut.findByCode(code);
    }
}
