package br.edu.ifpb.padroes.modelo;

import java.util.Date;

public class Conta {

    private String numero;
    private float saldo;
    private Date dataAbertura;
    private Agencia agencia;

    public Conta() {

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "NUMERO: " + this.numero + " | DATA DE ABERTURA: " + this.dataAbertura
                + " | AGENCIA: " + this.agencia.getNumero();
    }
}
