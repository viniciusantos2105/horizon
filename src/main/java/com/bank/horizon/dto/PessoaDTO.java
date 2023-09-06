package com.bank.horizon.dto;

import com.bank.horizon.models.Conta;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    @NotNull
    private String nome;
    @NotNull
    private String telefone;
    @NotNull
    private String cpf;

    private List<Conta> listaContas;
}
