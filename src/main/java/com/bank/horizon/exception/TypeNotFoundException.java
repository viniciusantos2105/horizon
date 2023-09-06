package com.bank.horizon.exception;

public class TypeNotFoundException extends RuntimeException{

    public TypeNotFoundException() {
        super("Tipo não encontrado!!");
    }
}
