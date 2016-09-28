package br.edu.ifpb.padroes.dao;

import java.sql.SQLException;
import br.edu.ifpb.padroes.interfaces.AdministradorDaoIF;
import br.edu.ifpb.padroes.interfaces.AgenciaDaoIF;
import br.edu.ifpb.padroes.interfaces.ClienteDaoIF;
import br.edu.ifpb.padroes.interfaces.ContaClienteDaoIF;
import br.edu.ifpb.padroes.interfaces.ContaDaoIF;
import br.edu.ifpb.padroes.interfaces.ContaUsuarioDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.interfaces.GerenteDaoIF;
import br.edu.ifpb.padroes.interfaces.GerenteGeralDaoIF;
import br.edu.ifpb.padroes.interfaces.MovimentacaoDaoIF;

public class DaoFactoryBD implements DaoFactoryIF {

    public DaoFactoryBD() {

    }

    public AdministradorDaoIF criarAdministradorDao() throws SQLException {
        return new AdministradorDao();
    }

    public AgenciaDaoIF criarAgenciaDao() throws SQLException {
        return new AgenciaDao();
    }

    public ClienteDaoIF criarClienteDao() throws SQLException {
        return new ClienteDao();
    }

    public ContaDaoIF criarContaDao() throws SQLException {
        return new ContaDao();
    }

    public GerenteDaoIF criarGerenteDao() throws SQLException {
        return new GerenteDao();
    }

    public GerenteGeralDaoIF criarGerenteGeralDao() throws SQLException {
        return new GerenteGeralDao();
    }

    public MovimentacaoDaoIF criarMovimentacaoDao() throws SQLException {
        return new MovimentacaoDao();
    }

    public ContaUsuarioDaoIF criarContaUsuarioDao() throws SQLException {
        return new ContaUsuarioDao();
    }
    
    
    public ContaClienteDaoIF criarContaClienteDao() throws SQLException {
        return new ContaClienteDao();
    }
}
