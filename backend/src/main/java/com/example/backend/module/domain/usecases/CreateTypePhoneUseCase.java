package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.ports.in.CreateTypePhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypePhoneRepositoryPortOut;

@Component
public class CreateTypePhoneUseCase implements CreateTypePhoneUseCasePortIn {
    private final ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut;

    public CreateTypePhoneUseCase(ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut) {
        this.typePhoneRepositoryPortOut = typePhoneRepositoryPortOut;
    }

    @Override
    public TypePhone execute(TypePhone typePhone) {
        return typePhoneRepositoryPortOut.save(typePhone);
    }
}



