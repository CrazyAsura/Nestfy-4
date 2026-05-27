package com.example.backend.module.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import com.example.backend.module.adapter.out.persistence.entities.interfaces.*;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends IOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private CartEntity cart;

    @ManyToOne(cascade = CascadeType.ALL)
    private ClientEntity client;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> product;

    private Integer quantity;

    private Double priceWithOutDiscount;

    private Double discountPercentage;

    private Double discountAmount;

    private Double total;
}
