package com.example.desafio.demo.controller;

import com.example.desafio.demo.exception.ContaNotFoundException;
import com.example.desafio.demo.model.Conta;
import com.example.desafio.demo.repository.ContaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Contas API Rest")
@RestController
public class ContaController {

    private final ContaRepository repository;

    public ContaController(ContaRepository repository) {
        this.repository = repository;
    }

    /* Recuperar informação de uma conta específica, /contas/{tal}    */
    @ApiOperation(value = "Recupera informações da url", response = Conta.class, notes = "Recupera todas as informações da url")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tudo certo", response = Conta.class),
            @ApiResponse(code = 404, message = "Não Encontrado", response = Conta.class),
    })
    @GetMapping("/desafio/contas")
    List<Conta> all() {
        return repository.findAll();
    }

    @ApiOperation(value = "Cria uma conta", response = Conta.class, notes = "Cria uma nova conta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tudo certo", response = Conta.class),
            @ApiResponse(code = 404, message = "Não Encontrado", response = Conta.class),
    })
    @PostMapping("/desafio/contas")
    Conta novaConta(@RequestBody Conta newConta) {
        return repository.save(newConta);
    }

    @ApiOperation("Recupera informações de uma conta especifíca")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tudo certo", response = Conta.class),
            @ApiResponse(code = 404, message = "Não Encontrado", response = Conta.class),
    })
    @GetMapping("/desafio/contas/{id}")
    Conta recuperaConta(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ContaNotFoundException(id));
    }

    @ApiOperation("Altera informações de uma conta específica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tudo certo", response = Conta.class),
            @ApiResponse(code = 404, message = "Não Encontrado", response = Conta.class),
    })
    @PutMapping("/desafio/contas/{id}")
    Conta substituirConta(@RequestBody Conta newConta, @PathVariable Long id) {
        return repository.findById(id).map(conta -> {
            conta.setSaldo(newConta.getSaldo());
            conta.setLimiteSaqueDiario(newConta.getLimiteSaqueDiario());
            conta.setFlagAtivo(newConta.getFlagAtivo());
            conta.setTipoConta(newConta.getTipoConta());
            conta.setDataCriacao(newConta.getDataCriacao());
            return repository.save(conta);
        }).orElseGet(()->{
            newConta.setId(id);
            return repository.save(newConta);
        });
    }
}
