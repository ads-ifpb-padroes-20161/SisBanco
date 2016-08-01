package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import br.edu.ifpb.padroes.modelo.Gerente;
import java.util.List;

public interface GerenteDaoIF{
	public void adicionarGerente(Gerente gerente) throws SQLException, ParseException;
        
	public void removerGerente(String cpf) throws SQLException;
        
	public void atualizarGerente(Gerente gerente)throws SQLException, ParseException;
        
	public Gerente buscarGerente(String cpf) throws SQLException;
        
        public List<Gerente> buscarTodos() throws SQLException;
}