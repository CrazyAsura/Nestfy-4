package com.example.backend.module.domain.factory.interfaces;

import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.models.User;

public interface IPhoneFactory {
    Phone createPhone(Long id, String ddd, String number, TypePhone typePhone, User user);
}
