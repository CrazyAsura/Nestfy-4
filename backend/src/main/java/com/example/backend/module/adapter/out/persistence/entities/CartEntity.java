package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartEntity extends ICartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProductEntity product;

    private Integer quantity;

    private Double priceWithOutDiscount;

    private Double discountPercentage;

    private Double discountAmount;

    private Double total;
}
