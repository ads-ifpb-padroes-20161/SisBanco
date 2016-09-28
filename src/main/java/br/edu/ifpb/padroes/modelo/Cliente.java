package br.edu.ifpb.padroes.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String cpf_cnpj;
    private String rg;
    private String nome;
    private String dataNasc;
    private String telefone;
    private String email;
    private String rua;
    private String numCasa;
    private String bairro;
    private String cidade;
    private String senha;
    private List<Conta> contas;

    public Cliente() {

    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void addConta(Conta conta) {
        if (contas == null) {
            contas = new ArrayList<Conta>();
        }
        contas.add(conta);
    }

    @Override
    public String toString() {
        return "CPF: " + this.cpf_cnpj + "\nRG: " + this.rg + "\nNOME: " + this.nome + "\nNASCIMENTO: " + this.dataNasc
                + "\nTELEFONE: " + this.telefone + "\nEMAIL: " + email + "\n[ENDEREÇO]" + "\n   RUA: " + this.rua
                + "   Nº: " + this.numCasa + "   BAIRRO: " + this.bairro + "   CIDADE: " + this.cidade;
    }
}
