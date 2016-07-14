package br.edu.ifpb.padroes.modelo;

public class Agencia {
	
	private int numero;
	private String nome;
	private String telefone;
	private String rua;
	private int numSede;
	private String bairro;
	private String cidade;
	private GerenteGeral gerenteG;

	public Agencia() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numAgencia) {
		this.numero = numAgencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone(){
		return telefone;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumSede() {
		return numSede;
	}

	public void setNumSede(int numSede) {
		this.numSede = numSede;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public GerenteGeral getGerenteG() {
		return gerenteG;
	}

	public void setGerenteG(GerenteGeral gerenteG) {
		this.gerenteG = gerenteG;
	}
	
	public String toString(){
		return "" + this.numero;
	}
}