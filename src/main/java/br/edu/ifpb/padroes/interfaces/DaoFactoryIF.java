package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;

public interface DaoFactoryIF {

    public AdministradorDaoIF criarAdministradorDao() throws SQLException;

    public AgenciaDaoIF criarAgenciaDao() throws SQLException;

    public ClienteDaoIF criarClienteDao() throws SQLException;

    public ContaDaoIF criarContaDao() throws SQLException;

    public GerenteDaoIF criarGerenteDao() throws SQLException;

    public GerenteGeralDaoIF criarGerenteGeralDao() throws SQLException;

    public MovimentacaoDaoIF criarMovimentacaoDao() throws SQLException;

    public ContaUsuarioDaoIF criarContaUsuarioDao() throws SQLException;

    public ContaClienteDaoIF criarContaClienteDao() throws SQLException;
}
