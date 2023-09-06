package com.bank.horizon.exception;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException() {
        super("Pessoa não encontrada!!");
    }
}
