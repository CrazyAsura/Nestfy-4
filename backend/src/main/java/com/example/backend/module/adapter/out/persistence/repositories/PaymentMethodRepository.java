package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.PaymentMethodEnum;
import com.example.backend.module.domain.models.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    public List<PaymentMethod> findByTypePaymentMethod(PaymentMethodEnum typePaymentMethod);

    public List<PaymentMethod> findByActive(Boolean active);
}
