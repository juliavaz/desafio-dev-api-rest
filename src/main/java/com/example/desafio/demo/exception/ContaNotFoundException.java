package com.example.desafio.demo.exception;

public class ContaNotFoundException extends RuntimeException {
    public ContaNotFoundException(Long id){
        super("Não foi possível encontrar a conta: "+id);
    }
}
