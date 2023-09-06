package com.bank.horizon.controller;

import com.bank.horizon.dto.TransferenciaDTO;
import com.bank.horizon.models.Transferencia;
import com.bank.horizon.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transferencia")
public class TransferenciaController {

    @Autowired
    private TransferenciaService service;

    @PostMapping("/perform")
    public Transferencia createTransferencia(@RequestBody TransferenciaDTO transferenciaDTO){
        return service.transferencia(transferenciaDTO);
    }
}
