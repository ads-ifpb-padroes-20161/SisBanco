package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import br.edu.ifpb.padroes.modelo.Administrador;
import java.util.List;

public interface AdministradorDaoIF{
	public void adicionarAdministrador(Administrador admin) throws SQLException, Exception;
        
	public void removerAdministrador(String cpf) throws SQLException;
        
	public void atualizarAdministrador(Administrador admin)throws SQLException, Exception;
        
	public Administrador buscarAdministrador(String cpf) throws SQLException;
        
        public List<Administrador> buscarTodos() throws SQLException;
}