package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_credit_card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardEntity extends ICreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;

    private String cardName;

    private String cardBrand;

    private String cardType;

    private String cardExpirationDate;

    private String cardCvv;

    private Boolean active;
}
