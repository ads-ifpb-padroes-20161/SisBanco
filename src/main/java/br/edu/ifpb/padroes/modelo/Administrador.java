package br.edu.ifpb.padroes.modelo;

public class Administrador {

    private String cpf;
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

    public Administrador() {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    @Override
    public String toString() {
        return "CPF: " + this.cpf + "\nRG: " + this.rg + "\nNOME: " + this.nome + "\nNASCIMENTO: " + this.dataNasc
                + "\nTELEFONE: " + this.telefone + "\nEMAIL: " + email + "\n[ENDERE�O]" + "\n   RUA: " + this.rua
                + "   N�: " + this.numCasa + "   BAIRRO: " + this.bairro + "   CIDADE: " + this.cidade;
    }
}
