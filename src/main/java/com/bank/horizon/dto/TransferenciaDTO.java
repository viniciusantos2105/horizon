package com.bank.horizon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaDTO {

    private Long numeroOrigem;
    private Long numeroDestino;
    private Double valor;
    private String data;
}
