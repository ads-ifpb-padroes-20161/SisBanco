package br.edu.ifpb.padroes.servico;

import java.sql.SQLException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.AdministradorDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Administrador;
import java.util.List;

public class AdministradorService {

    private DaoFactoryIF fabrica = null;
    private AdministradorDaoIF administradorDao = null;

    public AdministradorService() throws SQLException {
        fabrica = DaoFactory.createFactory();
        administradorDao = fabrica.criarAdministradorDao();
    }

    public void adicionarAdministrador(Administrador administrador) throws Exception {

        administradorDao.adicionarAdministrador(administrador);
    }

    public Administrador pesquisarAdministrador(String cpf) throws SQLException {
        Administrador administrador = administradorDao.buscarAdministrador(cpf);
        return administrador;
    }

    public List<Administrador> listarTodos() throws SQLException {
        return administradorDao.buscarTodos();
    }

    public void deletarAdministrador(String cpf) throws SQLException {
        administradorDao.removerAdministrador(cpf);
    }

    public void alterarAdministrador(Administrador administrador) throws Exception {

        administradorDao.atualizarAdministrador(administrador);
    }
}
