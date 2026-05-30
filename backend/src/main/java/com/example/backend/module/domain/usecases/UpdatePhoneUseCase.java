package com.example.backend.module.domain.usecases;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.ports.in.UpdatePhoneUseCasePortIn;
import com.example.backend.module.domain.ports.out.IPhoneRepositoryPortOut;

public class UpdatePhoneUseCase implements UpdatePhoneUseCasePortIn {
    private final IPhoneRepositoryPortOut phoneRepositoryPortOut;

    public UpdatePhoneUseCase(IPhoneRepositoryPortOut phoneRepositoryPortOut) {
        this.phoneRepositoryPortOut = phoneRepositoryPortOut;
    }

    @Override
    public Phone execute(Phone phone) {
        return phoneRepositoryPortOut.save(phone);
    }
}

