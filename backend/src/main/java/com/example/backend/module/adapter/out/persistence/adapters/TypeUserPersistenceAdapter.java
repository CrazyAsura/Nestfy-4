package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.TypeUser;
import com.example.backend.module.domain.ports.out.ITypeUserRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateTypeUserUseCase;
import com.example.backend.module.domain.usecases.DeleteTypeUserUseCase;
import com.example.backend.module.domain.usecases.GetTypeUserUseCase;
import com.example.backend.module.domain.usecases.UpdateTypeUserUseCase;
import com.example.backend.module.domain.models.TypeUserEnum;
import com.example.backend.module.domain.models.User;

@Component
public class TypeUserPersistenceAdapter {

    private final CreateTypeUserUseCase createTypeUserUseCase;
    private final GetTypeUserUseCase getTypeUserUseCase;
    private final UpdateTypeUserUseCase updateTypeUserUseCase;
    private final DeleteTypeUserUseCase deleteTypeUserUseCase;
    private final ITypeUserRepositoryPortOut typeUserRepositoryPortOut;

    @Autowired
    public TypeUserPersistenceAdapter(CreateTypeUserUseCase createTypeUserUseCase,
            GetTypeUserUseCase getTypeUserUseCase,
            UpdateTypeUserUseCase updateTypeUserUseCase,
            DeleteTypeUserUseCase deleteTypeUserUseCase,
            ITypeUserRepositoryPortOut typeUserRepositoryPortOut) {
        this.createTypeUserUseCase = createTypeUserUseCase;
        this.getTypeUserUseCase = getTypeUserUseCase;
        this.updateTypeUserUseCase = updateTypeUserUseCase;
        this.deleteTypeUserUseCase = deleteTypeUserUseCase;
        this.typeUserRepositoryPortOut = typeUserRepositoryPortOut;
    }

    public Optional<TypeUser> findById(Long id) {
        return Optional.ofNullable(getTypeUserUseCase.execute(id));
    }

    public Iterable<TypeUser> findAll() {
        return typeUserRepositoryPortOut.findAll();
    }

    public TypeUser save(TypeUser entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createTypeUserUseCase.execute(entity);
        } else {
            return updateTypeUserUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteTypeUserUseCase.execute(id);
    }

    public List<TypeUser> findByType(TypeUserEnum type) {
        return typeUserRepositoryPortOut.findByType(type);
    }

    public List<TypeUser> findByUser(User user) {
        return typeUserRepositoryPortOut.findByUser(user);
    }
}
