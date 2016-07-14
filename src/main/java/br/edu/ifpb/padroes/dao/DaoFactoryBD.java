package br.edu.ifpb.padroes.dao;

import java.sql.SQLException;

import br.edu.ifpb.padroes.interfaces.AdministradorDaoIF;
import br.edu.ifpb.padroes.interfaces.AgenciaDaoIF;
import br.edu.ifpb.padroes.interfaces.ClienteDaoIF;
import br.edu.ifpb.padroes.interfaces.ContaDaoIF;
import br.edu.ifpb.padroes.interfaces.ContaUsuarioDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.interfaces.GerenteDaoIF;
import br.edu.ifpb.padroes.interfaces.GerenteGeralDaoIF;
import br.edu.ifpb.padroes.interfaces.MovimentacaoDaoIF;

public class DaoFactoryBD implements DaoFactoryIF {

    public DaoFactoryBD() {

    }

    public AdministradorDaoIF criaAdministradorDao() throws SQLException {
        return new AdministradorDao();
    }

    public AgenciaDaoIF criaAgenciaDao() throws SQLException {
        return new AgenciaDao();
    }

    public ClienteDaoIF criaClienteDao() throws SQLException {
        return new ClienteDao();
    }

    public ContaDaoIF criaContaDao() throws SQLException {
        return new ContaDao();
    }

    public GerenteDaoIF criaGerenteDao() throws SQLException {
        return new GerenteDao();
    }

    public GerenteGeralDaoIF criaGerenteGeralDao() throws SQLException {
        return new GerenteGeralDao();
    }

    public MovimentacaoDaoIF criaMovimentacaoDao() throws SQLException {
        return new MovimentacaoDao();
    }

    public ContaUsuarioDaoIF criaContaUsuarioDao() throws SQLException {
        return new ContaUsuarioDao();
    }
}
