package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.ports.in.GetTypePhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypePhoneRepositoryPortOut;

public class GetTypePhoneUseCase implements GetTypePhoneUseCasePortIn {
    private final ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut;

    public GetTypePhoneUseCase(ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut) {
        this.typePhoneRepositoryPortOut = typePhoneRepositoryPortOut;
    }

    @Override
    public TypePhone execute(Long id) {
        return typePhoneRepositoryPortOut.findById(id).orElse(null);
    }
}

