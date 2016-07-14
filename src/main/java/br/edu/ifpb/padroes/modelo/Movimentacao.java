package br.edu.ifpb.padroes.modelo;

import java.util.Date;

public class Movimentacao{
	
	private Conta conta;
	private Conta destino;
	private Cliente cliente;
	private Administrador admin;
	private float valor;
	private Date dataHora;
	private String tipoMovimentacao;

	public Movimentacao(){
		dataHora = new Date();
	}

	public Date getDataHora(){
		return dataHora;
	}

	public void setDataHora(Date dataHora){
		this.dataHora = dataHora;
	}

	public Conta getConta(){
		return conta;
	}

	public void setConta(Conta conta){
		this.conta = conta;
	}

	public Cliente getCliente(){
		return cliente;
	}

	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}

	public String getTipoMovimentacao(){
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao){
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public float getValor(){
		return valor;
	}

	public void setValor(float valor){
		this.valor = valor;
	}

	public Conta getDestino() {
		return destino;
	}

	public void setDestino(Conta destino) {
		this.destino = destino;
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}
	
}