package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.backend.module.domain.models.PaymentStatusEnum;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_payment_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentStatusEntity extends IPaymentStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PaymentStatusEnum status;

    private Boolean active;
}
