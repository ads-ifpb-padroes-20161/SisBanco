package br.edu.ifpb.padroes.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta{

	private int numero;
	private float saldo;
	private Date dataAbertura;
	private Agencia agencia;

	public Conta(){
		
	}

	public int getNumero(){
		return numero;
	}
	
	public void setNumero(int numero){
		this.numero = numero;
	}

	public float getSaldo(){
		return saldo;
	}

	public void setSaldo(float saldo){
		this.saldo = saldo;
	}

	public Date getDataAbertura(){
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura){
		this.dataAbertura = dataAbertura;
	}
	
	public Agencia getAgencia(){
		return agencia;
	}
	
	public void setAgencia(Agencia agencia){
		this.agencia = agencia;
	}

	public String toString(){
		return "NUMERO: " + this.numero + "\nSALDO: " + this.saldo + "\nDATA DE ABERTURA: " + this.dataAbertura +
				"\nAGENCIA: " + this.agencia.getNumero();
	}
}