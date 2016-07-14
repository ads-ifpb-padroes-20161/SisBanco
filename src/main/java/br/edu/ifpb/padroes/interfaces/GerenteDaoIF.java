package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import java.text.ParseException;

import br.edu.ifpb.padroes.modelo.Gerente;

public interface GerenteDaoIF{
	public void addGerente(Gerente gerente) throws SQLException, ParseException;
	public void removeGerente(String cpf) throws SQLException;
	public void atualizarGerente(Gerente gerente)throws SQLException, ParseException;
	public Gerente buscaGerente(String cpf) throws SQLException;
}
