package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.ports.in.CreateTypePhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypePhoneRepositoryPortOut;

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



