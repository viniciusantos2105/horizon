package com.bank.horizon.repository;

import com.bank.horizon.models.Conta;
import com.bank.horizon.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    List<Optional<Conta>> findByPessoa(Pessoa pessoa);

    Optional<Conta> findByNumero(Long numero);
}
