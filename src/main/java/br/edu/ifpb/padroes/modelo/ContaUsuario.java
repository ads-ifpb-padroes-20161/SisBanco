package br.edu.ifpb.padroes.modelo;

import br.edu.ifpb.padroes.enums.TipoConta;

public class ContaUsuario {

    private String cpf;
    private String senha;
    private TipoConta tipoConta;

    public ContaUsuario(String cpf, String senha, TipoConta tipoConta) {
        this.cpf = cpf;
        this.senha = senha;
        this.tipoConta = tipoConta;
    }

    public ContaUsuario() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
}