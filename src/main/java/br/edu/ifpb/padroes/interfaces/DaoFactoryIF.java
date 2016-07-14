package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;

public interface DaoFactoryIF {
	
	public AdministradorDaoIF criaAdministradorDao() throws SQLException;
	
	public AgenciaDaoIF criaAgenciaDao() throws SQLException;
	
	public ClienteDaoIF criaClienteDao() throws SQLException;
	
	public ContaDaoIF criaContaDao() throws SQLException;
	
	public GerenteDaoIF criaGerenteDao() throws SQLException;
	
	public GerenteGeralDaoIF criaGerenteGeralDao() throws SQLException;
	
	public MovimentacaoDaoIF criaMovimentacaoDao() throws SQLException;
        
        public ContaUsuarioDaoIF criaContaUsuarioDao() throws SQLException;
        
        
}
