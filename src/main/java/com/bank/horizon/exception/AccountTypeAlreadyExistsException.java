package com.bank.horizon.exception;

public class AccountTypeAlreadyExistsException extends RuntimeException{

    public AccountTypeAlreadyExistsException() {
        super("Você já possui este tipo de conta!!");
    }
}
