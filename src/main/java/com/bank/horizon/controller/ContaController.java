package com.bank.horizon.controller;

import com.bank.horizon.dto.ContaDTO;
import com.bank.horizon.models.Conta;
import com.bank.horizon.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

    @Autowired
    private ContaService service;

    @PostMapping("/create")
    public Conta createConta(@RequestBody ContaDTO contaDTO){
        return service.createConta(contaDTO);
    }

    @GetMapping("/balance")
    public String consultSaldo(@RequestBody ContaDTO contaDTO){
        return service.consultSaldo(contaDTO);
    }

    @PatchMapping("/deposit")
    public Conta depositSaldo(@RequestBody ContaDTO contaDTO) { return service.depositSaldo(contaDTO); }

    @PatchMapping("/withdraw")
    public Conta withdrawSaldo(@RequestBody ContaDTO contaDTO){
        return service.withdrawSaldo(contaDTO);
    }
}
