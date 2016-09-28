package br.edu.ifpb.padroes.gerenciadores;

import java.sql.SQLException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.AdministradorDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Administrador;

public class GerenciadorDeAdministrador {

    private DaoFactoryIF fabrica = null;
    private AdministradorDaoIF administradorDao = null;

    public GerenciadorDeAdministrador() throws SQLException {
        fabrica = DaoFactory.createFactory();
        administradorDao = fabrica.criarAdministradorDao();
    }

    public void adicionarAdministrador(Administrador admin) throws SQLException, Exception {

        administradorDao.adicionarAdministrador(admin);

    }

    public String pesquisarAdministrador(String cpf) throws SQLException {
        Administrador admin = administradorDao.buscarAdministrador(cpf);
        return admin.toString();
    }

    public void deletarAdministrador(String cpf) throws SQLException {
        administradorDao.removerAdministrador(cpf);
    }

    public void alterarAdministrador(Administrador admin) throws SQLException, Exception {

        administradorDao.atualizarAdministrador(admin);
    }
}
