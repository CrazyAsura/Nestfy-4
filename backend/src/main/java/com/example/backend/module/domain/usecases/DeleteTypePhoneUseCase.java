package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeleteTypePhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.ITypePhoneRepositoryPortOut;

@Component
public class DeleteTypePhoneUseCase implements DeleteTypePhoneUseCasePortIn {
    private final ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut;

    public DeleteTypePhoneUseCase(ITypePhoneRepositoryPortOut typePhoneRepositoryPortOut) {
        this.typePhoneRepositoryPortOut = typePhoneRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        typePhoneRepositoryPortOut.deleteById(id);
    }
}

