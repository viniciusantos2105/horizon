package com.bank.horizon.exception;

public class CpfAlreadyExistsException extends RuntimeException{

    public CpfAlreadyExistsException() {
        super("Cpf já foi cadastrado!!");
    }
}
