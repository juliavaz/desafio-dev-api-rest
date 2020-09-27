package com.example.desafio.demo.exception;

public class TransacaoNotFoundException extends RuntimeException {
    public TransacaoNotFoundException(Long id){
        super("Não foi possível encontrar a transação: "+id);
    }
}
