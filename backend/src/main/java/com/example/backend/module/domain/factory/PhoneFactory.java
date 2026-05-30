package com.example.backend.module.domain.factory;
import com.example.backend.module.domain.models.Phone;
import com.example.backend.module.domain.models.TypePhone;
import com.example.backend.module.domain.models.User;

public class PhoneFactory {
    public static Phone createPhone(Long id, String ddd, String number, TypePhone typePhone, User user) {
        Phone phone = new Phone();
        phone.setId(id);
        phone.setDdd(ddd);
        phone.setNumber(number);
        phone.setTypePhone(typePhone);
        phone.setUser(user);
        return phone;
    }
}
