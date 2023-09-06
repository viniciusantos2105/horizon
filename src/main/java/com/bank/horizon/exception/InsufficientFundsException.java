package com.bank.horizon.exception;

public class InsufficientFundsException extends RuntimeException{

    public InsufficientFundsException() {
        super("Saldo insuficiente!!");
    }
}
