package com.bank.horizon.service;

import com.bank.horizon.dto.PessoaDTO;
import com.bank.horizon.exception.CpfAlreadyExistsException;
import com.bank.horizon.exception.PersonNotFoundException;
import com.bank.horizon.exception.PhoneAlreadyRegisteredException;
import com.bank.horizon.models.Pessoa;
import com.bank.horizon.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa createPerson(PessoaDTO pessoaDTO){
        verifyTelefone(pessoaDTO.getTelefone());
        if(!verifyCpf(pessoaDTO.getCpf())){
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(pessoaDTO.getNome());
            pessoa.setCpf(pessoaDTO.getCpf());
            pessoa.setTelefone(pessoaDTO.getTelefone());
            return repository.save(pessoa);
        }
        throw new CpfAlreadyExistsException();
    }

    public void verifyTelefone(String telefone){
        if(repository.findByTelefone(telefone).isPresent()){
            throw new PhoneAlreadyRegisteredException();
        }
    }

    public Pessoa findByCpf(String cpf){
        return repository.findByCpf(cpf).orElseThrow(PersonNotFoundException::new);
    }

    public Boolean verifyCpf(String cpf){
        return repository.findByCpf(cpf).isPresent();
    }
}
