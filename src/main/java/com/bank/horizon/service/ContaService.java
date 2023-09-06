package com.bank.horizon.service;

import com.bank.horizon.dto.ContaDTO;
import com.bank.horizon.enums.Tipo;
import com.bank.horizon.exception.*;
import com.bank.horizon.models.Conta;
import com.bank.horizon.models.Pessoa;
import com.bank.horizon.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private PessoaService pessoaService;

    public Conta createConta(ContaDTO contaDTO){
        if(pessoaService.verifyCpf(contaDTO.getCpf())) {
                Pessoa pessoa = pessoaService.findByCpf(contaDTO.getCpf());
                if(!verifyConta(pessoa, contaDTO)){
                Conta conta = new Conta();
                conta.setPessoa(pessoa);
                conta.setSaldo(0.0);
                conta.setTipoConta(typeConta(contaDTO.getTipoConta()));
                conta.setNumero(generatingAccountNumber());
                conta.setDigito(1);
                return repository.save(conta);
            }
        }
        throw new PersonNotFoundException();
    }

    public Conta depositSaldo(ContaDTO contaDTO){
        verifySaldo(contaDTO.getSaldo());
        Conta conta = findContaByNumero(contaDTO.getNumero());
        conta.setSaldo(conta.getSaldo() + contaDTO.getSaldo());
        return repository.save(conta);
    }

    public Conta withdrawSaldo(ContaDTO contaDTO){
        verifySaldo(contaDTO.getSaldo());
        Conta conta = findContaByNumero(contaDTO.getNumero());
        if(conta.getSaldo() < contaDTO.getSaldo()){
            throw new InsufficientFundsException();
        }
        conta.setSaldo(conta.getSaldo() - contaDTO.getSaldo());
        return repository.save(conta);
    }

    public String consultSaldo(ContaDTO contaDTO){
        Conta conta = findContaByNumero(contaDTO.getNumero());
        return "Saldo: R$" + conta.getSaldo();
    }

    public void verifySaldo(Double saldo){
        if(saldo < 0){
            throw new InsufficientFundsException();
        }
    }

    public Conta findContaByNumero(Long id){
        if(repository.findByNumero(id).isPresent()){
            return repository.findByNumero(id).get();
        }
        throw new AccountNotFoundException();
    }

    public boolean verifyConta(Pessoa pessoa, ContaDTO contaDTO){
        List<Optional<Conta>> list = repository.findByPessoa(pessoa);
        int size = list.size();
        if(size == 0){
            return false;
        }
        size--;
        for(int x = size; x >= 0; x--){
            if(list.get(x).get().getTipoConta().getSigla().equals(contaDTO.getTipoConta())){
                throw new AccountTypeAlreadyExistsException();

            }
        }
        return false;
    }

    public Tipo typeConta(String tipoConta){
        if(tipoConta.equals("C")) {
            return Tipo.CORRENTE;
        }else if(tipoConta.equals("P")){
            return Tipo.POUPANCA;
        }
       throw new TypeNotFoundException();
    }

    public Long generatingAccountNumber(){
        Double randomNumber = Math.random();
        String stringNumber = String.valueOf(randomNumber);
        int size = stringNumber.length();
        int reference = stringNumber.indexOf(".");
        String numberAccount = stringNumber.substring(reference + 1, size);
        return Long.valueOf(numberAccount);
    }

    public void save(Conta conta){
        repository.save(conta);
    }
}
