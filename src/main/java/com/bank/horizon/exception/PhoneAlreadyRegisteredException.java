package com.bank.horizon.exception;

public class PhoneAlreadyRegisteredException extends RuntimeException{

    public PhoneAlreadyRegisteredException() {
        super("Telefone já cadastrado!!");
    }
}
