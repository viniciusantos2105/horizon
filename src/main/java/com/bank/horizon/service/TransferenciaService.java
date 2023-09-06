package com.bank.horizon.service;

import com.bank.horizon.dto.TransferenciaDTO;
import com.bank.horizon.exception.InsufficientFundsException;
import com.bank.horizon.models.Conta;
import com.bank.horizon.models.Transferencia;
import com.bank.horizon.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository repository;

    @Autowired
    private ContaService contaService;

    public Transferencia transferencia(TransferenciaDTO transferenciaDTO){
        contaService.verifySaldo(transferenciaDTO.getValor());
        Conta contaOrigem = contaService.findContaByNumero(transferenciaDTO.getNumeroOrigem());
        Conta contaDestino = contaService.findContaByNumero(transferenciaDTO.getNumeroDestino());

        if(contaOrigem.getSaldo() < transferenciaDTO.getValor()){
            throw new InsufficientFundsException();
        }
        consultTransferencia(contaOrigem, contaDestino, transferenciaDTO.getValor());
        return organizingTransferencia(contaOrigem, contaDestino, transferenciaDTO.getValor());
    }

    public Transferencia organizingTransferencia(Conta contaOrigem, Conta contaDestino, Double valor){
        Transferencia transferencia = new Transferencia();
        transferencia.setData(dataFormat());
        transferencia.setValor(valor);
        transferencia.setContaOrigem(contaOrigem);
        transferencia.setContaDestino(contaDestino);
        return repository.save(transferencia);
    }

    public String dataFormat(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        return formatter.format(now);
    }

    public void consultTransferencia(Conta contaOrigem, Conta contaDestino, Double valor){
        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
        contaService.save(contaDestino);
        contaService.save(contaOrigem);
    }
}
