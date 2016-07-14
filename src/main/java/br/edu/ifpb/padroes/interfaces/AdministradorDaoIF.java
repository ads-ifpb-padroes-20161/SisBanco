package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;

import br.edu.ifpb.padroes.modelo.Administrador;

public interface AdministradorDaoIF{
	public void addAdministrador(Administrador admin) throws SQLException, Exception;
	public void removeAdministrador(String cpf) throws SQLException;
	public void atualizarAdministrador(Administrador admin)throws SQLException, Exception;
	public Administrador buscaAdministrador(String cpf) throws SQLException;
}