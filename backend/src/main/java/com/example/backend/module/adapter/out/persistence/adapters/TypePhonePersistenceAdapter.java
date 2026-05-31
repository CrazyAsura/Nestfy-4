package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.ports.out.ITypePhoneRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateTypePhoneUseCase;
import com.example.backend.module.domain.usecases.DeleteTypePhoneUseCase;
import com.example.backend.module.domain.usecases.GetTypePhoneUseCase;
import com.example.backend.module.domain.usecases.UpdateTypePhoneUseCase;
import com.example.backend.module.domain.models.TypePhoneEnum;
import com.example.backend.module.domain.models.User;

@Component
public class TypePhonePersistenceAdapter {

    private final CreateTypePhoneUseCase createTypePhoneUseCase;
    private final GetTypePhoneUseCase getTypePhoneUseCase;
    private final UpdateTypePhoneUseCase updateTypePhoneUseCase;
    private final DeleteTypePhoneUseCase deleteTypePhoneUseCase;
    private final ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut;

    @Autowired
    public TypePhonePersistenceAdapter(CreateTypePhoneUseCase createTypePhoneUseCase,
            GetTypePhoneUseCase getTypePhoneUseCase,
            UpdateTypePhoneUseCase updateTypePhoneUseCase,
            DeleteTypePhoneUseCase deleteTypePhoneUseCase,
            ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut) {
        this.createTypePhoneUseCase = createTypePhoneUseCase;
        this.getTypePhoneUseCase = getTypePhoneUseCase;
        this.updateTypePhoneUseCase = updateTypePhoneUseCase;
        this.deleteTypePhoneUseCase = deleteTypePhoneUseCase;
        this.typePhoneRepositoryPortOut = typePhoneRepositoryPortOut;
    }

    public Optional<TypePhone> findById(Long id) {
        return Optional.ofNullable(getTypePhoneUseCase.execute(id));
    }

    public Iterable<TypePhone> findAll() {
        return typePhoneRepositoryPortOut.findAll();
    }

    public TypePhone save(TypePhone entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createTypePhoneUseCase.execute(entity);
        } else {
            return updateTypePhoneUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deleteTypePhoneUseCase.execute(id);
    }

    public List<TypePhone> findByType(TypePhoneEnum type) {
        return typePhoneRepositoryPortOut.findByType(type);
    }

    public List<TypePhone> findByUser(User user) {
        return typePhoneRepositoryPortOut.findByUser(user);
    }
}
