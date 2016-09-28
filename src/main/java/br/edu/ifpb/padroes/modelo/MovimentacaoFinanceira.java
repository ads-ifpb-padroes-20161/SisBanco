package br.edu.ifpb.padroes.modelo;

import br.edu.ifpb.padroes.enums.Movimentacao;
import java.util.Date;

public class MovimentacaoFinanceira {

    private Conta conta;
    private Cliente cliente;
    private Administrador admin;
    private float valor;
    private Date dataHora;
    private Movimentacao tipoMovimentacao;

    public MovimentacaoFinanceira() {

    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setData(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public Movimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(Movimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public String toString(){
        return "CONTA: " + this.conta.getNumero() + " | VALOR: R$" + this.valor
                + " | DATA: " + this.dataHora + " | TIPO: " + this.tipoMovimentacao;
    }
}
