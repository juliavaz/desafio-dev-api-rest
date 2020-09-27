package com.example.desafio.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_conta")
public class Conta {

    @Id
    @Column(name = "id_conta")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @Basic(optional = false)
    private BigDecimal saldo;

    @Basic(optional = false)
    @Column(name = "limite_saque_diario")
    private BigDecimal limiteSaqueDiario;

    @Basic(optional = false)
    @Column(name = "flag_ativo")
    private boolean flagAtivo;

    @Basic(optional = false)
    @Column(name = "tipo_conta")
    private Long tipoConta;

    @Basic(optional = false)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    @OneToMany(mappedBy = "conta")
    private List<Transacao> transacoes;

    public Long getId() {
        return id;
    }

    public Pessoa nome(){
        return pessoa;
    }

    public void setId(Long idConta) {
        this.id = idConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getLimiteSaqueDiario() {
        return limiteSaqueDiario;
    }

    public void setLimiteSaqueDiario(BigDecimal limiteSaqueDiario) {
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    public boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public Long getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Long tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return flagAtivo == conta.flagAtivo &&
                Objects.equals(id, conta.id) &&
                Objects.equals(pessoa, conta.pessoa) &&
                Objects.equals(saldo, conta.saldo) &&
                Objects.equals(limiteSaqueDiario, conta.limiteSaqueDiario) &&
                Objects.equals(tipoConta, conta.tipoConta) &&
                Objects.equals(dataCriacao, conta.dataCriacao) &&
                Objects.equals(transacoes, conta.transacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pessoa, saldo, limiteSaqueDiario, flagAtivo, tipoConta, dataCriacao, transacoes);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Conta{");
        sb.append("id=").append(id);
        sb.append(", pessoa=").append(pessoa);
        sb.append(", saldo=").append(saldo);
        sb.append(", limiteSaqueDiario=").append(limiteSaqueDiario);
        sb.append(", flagAtivo=").append(flagAtivo);
        sb.append(", tipoConta=").append(tipoConta);
        sb.append(", dataCriacao=").append(dataCriacao);
        sb.append(", transacoes=").append(transacoes);
        sb.append('}');
        return sb.toString();
    }
}
