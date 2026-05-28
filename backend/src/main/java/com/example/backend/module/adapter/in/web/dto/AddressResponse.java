package com.example.backend.module.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private Long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private String typeCode;
    private String typeDescription;
    private Boolean active;
    private Boolean preferred;
    private String cep;
    private String addressCode;
    private Long clientId;
}
