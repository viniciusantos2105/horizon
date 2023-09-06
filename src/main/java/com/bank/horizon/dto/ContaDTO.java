package com.bank.horizon.dto;

import com.bank.horizon.enums.Tipo;
import com.bank.horizon.models.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaDTO {

    private Long id;
    private String cpf;
    private Long numero;
    private Integer digito;
    private Double saldo;
    private String tipoConta;
    private Pessoa pessoa;
}
