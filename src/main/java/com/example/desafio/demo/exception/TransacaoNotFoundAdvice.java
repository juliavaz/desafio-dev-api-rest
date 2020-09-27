package com.example.desafio.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TransacaoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TransacaoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String TransacaoNotFoundAdvice(TransacaoNotFoundException ex){
        return ex.getMessage();
    }
}
