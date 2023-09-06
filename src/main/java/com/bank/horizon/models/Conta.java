package com.bank.horizon.models;

import com.bank.horizon.enums.Tipo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numero;
    private Integer digito;
    private Double saldo;
    @NotNull
    private Tipo tipoConta;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pessoa pessoa;
}
