package com.example.desafio.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_transacao")
public class Transacao {

    @Id
    @Column(name = "id_transacao")
    @GeneratedValue
    private Long idTransacao;

    @ManyToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;

    private BigDecimal valor;
    private Date dataTransacao;

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transacao)) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(idTransacao, transacao.idTransacao) &&
                Objects.equals(conta, transacao.conta) &&
                Objects.equals(valor, transacao.valor) &&
                Objects.equals(dataTransacao, transacao.dataTransacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransacao, conta, valor, dataTransacao);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transacao{");
        sb.append("idTransacao=").append(idTransacao);
        sb.append(", conta=").append(conta);
        sb.append(", valor=").append(valor);
        sb.append(", dataTransacao=").append(dataTransacao);
        sb.append('}');
        return sb.toString();
    }
}
