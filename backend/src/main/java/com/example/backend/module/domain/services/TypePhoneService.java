package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.ports.out.ITypePhoneRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreateTypePhoneUseCase;
import com.example.backend.module.domain.usecases.DeleteTypePhoneUseCase;
import com.example.backend.module.domain.usecases.GetTypePhoneUseCase;
import com.example.backend.module.domain.usecases.UpdateTypePhoneUseCase;
import org.springframework.stereotype.Service;

@Service
public class TypePhoneService {
    private final CreateTypePhoneUseCase createTypePhoneUseCase;
    private final GetTypePhoneUseCase getTypePhoneUseCase;
    private final UpdateTypePhoneUseCase updateTypePhoneUseCase;
    private final DeleteTypePhoneUseCase deleteTypePhoneUseCase;

    public TypePhoneService(ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut) {
        this.createTypePhoneUseCase = new CreateTypePhoneUseCase(typePhoneRepositoryPortOut);
        this.getTypePhoneUseCase = new GetTypePhoneUseCase(typePhoneRepositoryPortOut);
        this.updateTypePhoneUseCase = new UpdateTypePhoneUseCase(typePhoneRepositoryPortOut);
        this.deleteTypePhoneUseCase = new DeleteTypePhoneUseCase(typePhoneRepositoryPortOut);
    }

    public TypePhone createTypePhone(TypePhone typephone) {
        return createTypePhoneUseCase.execute(typephone);
    }

    public TypePhone getTypePhone(Long id) {
        return getTypePhoneUseCase.execute(id);
    }

    public TypePhone updateTypePhone(TypePhone typephone) {
        return updateTypePhoneUseCase.execute(typephone);
    }

    public void deleteTypePhone(Long id) {
        deleteTypePhoneUseCase.execute(id);
    }
}
