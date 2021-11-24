package com.sefa.examples.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String customerId) {
        super("Customer not found with given id : " + customerId);
    }
}
