package br.edu.ifpb.padroes.modelo;

public class ContaCliente {
  private String cpf;
    private String numConta;

    public ContaCliente() {
    }

    public ContaCliente(String cpf, String numConta) {
        this.cpf = cpf;
        this.numConta = numConta;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

}