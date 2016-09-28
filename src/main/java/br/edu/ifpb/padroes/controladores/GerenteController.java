package br.edu.ifpb.padroes.controladores;

import java.sql.SQLException;
import java.text.ParseException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.interfaces.GerenteDaoIF;
import br.edu.ifpb.padroes.modelo.Agencia;
import br.edu.ifpb.padroes.modelo.Gerente;

public class GerenteController {
	
	private DaoFactoryIF fabrica = null;
	private GerenteDaoIF gerenteDao = null;
	
	public GerenteController() throws SQLException{
		fabrica = DaoFactory.createFactory();
		gerenteDao = fabrica.criarGerenteDao();
	}
	
	public void adicionarGerente(Gerente gerente) throws SQLException, ParseException{
		
		gerenteDao.adicionarGerente(gerente);
		
	}
	
	public Gerente pesquisarGerente(String cpf) throws SQLException{
		Gerente gerente = gerenteDao.buscarGerente(cpf); 
		return gerente;
	}
	
	public void deletarGerente(String cpf) throws SQLException{
		gerenteDao.removerGerente(cpf);
	}
	
	public void alterarGerente(Gerente gerente) throws SQLException, ParseException{
		
		gerenteDao.atualizarGerente(gerente);
	}
}