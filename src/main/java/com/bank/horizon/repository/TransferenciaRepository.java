package com.bank.horizon.repository;

import com.bank.horizon.models.Pessoa;
import com.bank.horizon.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
