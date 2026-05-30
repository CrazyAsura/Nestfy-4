package com.example.backend.module.domain.services;

import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.ports.out.IPhoneRepositoryPortOut;
import com.example.backend.module.domain.usecases.CreatePhoneUseCase;
import com.example.backend.module.domain.usecases.DeletePhoneUseCase;
import com.example.backend.module.domain.usecases.GetPhoneUseCase;
import com.example.backend.module.domain.usecases.UpdatePhoneUseCase;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {
    private final CreatePhoneUseCase createPhoneUseCase;
    private final GetPhoneUseCase getPhoneUseCase;
    private final UpdatePhoneUseCase updatePhoneUseCase;
    private final DeletePhoneUseCase deletePhoneUseCase;

    public PhoneService(IPhoneRepositoryPortOut phoneRepositoryPortOut) {
        this.createPhoneUseCase = new CreatePhoneUseCase(phoneRepositoryPortOut);
        this.getPhoneUseCase = new GetPhoneUseCase(phoneRepositoryPortOut);
        this.updatePhoneUseCase = new UpdatePhoneUseCase(phoneRepositoryPortOut);
        this.deletePhoneUseCase = new DeletePhoneUseCase(phoneRepositoryPortOut);
    }

    public Phone createPhone(Phone phone) {
        return createPhoneUseCase.execute(phone);
    }

    public Phone getPhone(Long id) {
        return getPhoneUseCase.execute(id);
    }

    public Phone updatePhone(Phone phone) {
        return updatePhoneUseCase.execute(phone);
    }

    public void deletePhone(Long id) {
        deletePhoneUseCase.execute(id);
    }
}
