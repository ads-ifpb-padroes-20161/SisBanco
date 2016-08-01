package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import br.edu.ifpb.padroes.modelo.GerenteGeral;
import java.util.List;

public interface GerenteGeralDaoIF{
	public void adicionarGerenteGeral(GerenteGeral gGeral) throws SQLException, ParseException;
        
	public void removerGerenteGeral(String cpf) throws SQLException;
        
	public void atualizarGerenteGeral(GerenteGeral gGeral)throws SQLException, ParseException;
        
	public GerenteGeral buscarGerenteGeral(String cpf) throws SQLException;
        
        public List<GerenteGeral> buscarTodos() throws SQLException;
}