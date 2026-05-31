package com.example.backend.module.domain.usecases;

import org.springframework.stereotype.Component;
import com.example.backend.module.domain.ports.in.DeletePhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPhoneRepositoryPortOut;

@Component
public class DeletePhoneUseCase implements DeletePhoneUseCasePortIn {
    private final IPhoneRepositoryPortOut phoneRepositoryPortOut;

    public DeletePhoneUseCase(IPhoneRepositoryPortOut phoneRepositoryPortOut) {
        this.phoneRepositoryPortOut = phoneRepositoryPortOut;
    }

    @Override
    public void execute(Long id) {
        phoneRepositoryPortOut.deleteById(id);
    }
}

