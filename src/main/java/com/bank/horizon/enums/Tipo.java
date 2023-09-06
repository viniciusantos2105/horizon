package com.bank.horizon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Tipo {
    POUPANCA(1, "P"),
    CORRENTE(2, "C");

    private final int identificacao;
    private final String sigla;
}
