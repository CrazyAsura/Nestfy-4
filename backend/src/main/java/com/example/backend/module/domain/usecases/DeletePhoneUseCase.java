package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.ports.in.DeletePhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPhoneRepositoryPortOut;

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

