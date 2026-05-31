package com.example.backend.module.adapter.out.persistence.adapters;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.backend.module.domain.models.*;
import com.example.backend.module.domain.ports.out.*;
import com.example.backend.module.domain.usecases.*;

@Component
public class PhonePersistenceAdapter {

    private final CreatePhoneUseCase createPhoneUseCase;
    private final GetPhoneUseCase getPhoneUseCase;
    private final UpdatePhoneUseCase updatePhoneUseCase;
    private final DeletePhoneUseCase deletePhoneUseCase;
    private final IPhoneRepositoryPortOut phoneRepositoryPortOut;

    @Autowired
    public PhonePersistenceAdapter(CreatePhoneUseCase createPhoneUseCase,
            GetPhoneUseCase getPhoneUseCase,
            UpdatePhoneUseCase updatePhoneUseCase,
            DeletePhoneUseCase deletePhoneUseCase,
            IPhoneRepositoryPortOut phoneRepositoryPortOut) {
        this.createPhoneUseCase = createPhoneUseCase;
        this.getPhoneUseCase = getPhoneUseCase;
        this.updatePhoneUseCase = updatePhoneUseCase;
        this.deletePhoneUseCase = deletePhoneUseCase;
        this.phoneRepositoryPortOut = phoneRepositoryPortOut;
    }

    public Optional<Phone> findById(Long id) {
        return Optional.ofNullable(getPhoneUseCase.execute(id));
    }

    public Iterable<Phone> findAll() {
        return phoneRepositoryPortOut.findAll();
    }

    public Phone save(Phone entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (entity.getId() == null) {
            return createPhoneUseCase.execute(entity);
        } else {
            return updatePhoneUseCase.execute(entity);
        }
    }

    public void deleteById(Long id) {
        deletePhoneUseCase.execute(id);
    }
    public Optional<Phone> findByNumber(String number) {
        return phoneRepositoryPortOut.findByNumber(number);
    }

    public List<Phone> findByUserId(Long userId) {
        return phoneRepositoryPortOut.findByUserId(userId);
    }
}
