package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_money")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoneyEntity extends IMoneyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String symbol;

    private Boolean active;
}
