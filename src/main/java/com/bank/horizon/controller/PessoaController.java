package com.bank.horizon.controller;

import com.bank.horizon.dto.PessoaDTO;
import com.bank.horizon.models.Pessoa;
import com.bank.horizon.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;

    @PostMapping("/create")
    public Pessoa createPerson(@RequestBody PessoaDTO pessoaDTO){
        return service.createPerson(pessoaDTO);
    }
}
