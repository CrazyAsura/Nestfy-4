package com.example.backend.module.adapter.out.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.module.domain.models.PaymentStatusEnum;
import com.example.backend.module.domain.models.PaymentStatus;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {

    public List<PaymentStatus> findByStatus(PaymentStatusEnum status);

    public List<PaymentStatus> findByActive(Boolean active);
}
