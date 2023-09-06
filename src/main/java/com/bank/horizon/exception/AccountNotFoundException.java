package com.bank.horizon.exception;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException() {
        super("Numero de conta inválido!!");
    }
}
