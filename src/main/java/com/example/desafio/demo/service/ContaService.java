package com.example.desafio.demo.service;

import com.example.desafio.demo.repository.ContaRepository;
import com.example.desafio.demo.repository.PessoaRepository;
import com.example.desafio.demo.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;
    private final PessoaRepository pessoaRepository;

    public ContaService(ContaRepository contaRepository, TransacaoRepository transacaoRepository, PessoaRepository pessoaRepository) {
        this.contaRepository = contaRepository;
        this.transacaoRepository = transacaoRepository;
        this.pessoaRepository = pessoaRepository;
    }



}
