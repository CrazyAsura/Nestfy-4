package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.ports.in.UpdateTypePhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypePhoneRepositoryPortOut;

public class UpdateTypePhoneUseCase implements UpdateTypePhoneUseCasePortIn {
    private final ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut;

    public UpdateTypePhoneUseCase(ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut) {
        this.typePhoneRepositoryPortOut = typePhoneRepositoryPortOut;
    }

    @Override
    public TypePhone execute(TypePhone typePhone) {
        return typePhoneRepositoryPortOut.save(typePhone);
    }
}

