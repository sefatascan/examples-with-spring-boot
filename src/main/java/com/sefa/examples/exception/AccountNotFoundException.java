package com.sefa.examples.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String accountId){
        super("Account not found with given id : " + accountId);
    }
}
