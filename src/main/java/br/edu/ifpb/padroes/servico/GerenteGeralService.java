package br.edu.ifpb.padroes.servico;

import java.sql.SQLException;
import java.text.ParseException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.interfaces.GerenteGeralDaoIF;
import br.edu.ifpb.padroes.modelo.GerenteGeral;

public class GerenteGeralService {

    private DaoFactoryIF fabrica = null;
    private GerenteGeralDaoIF gerenteGeralDao = null;

    public GerenteGeralService() throws SQLException {
        fabrica = DaoFactory.createFactory();
        gerenteGeralDao = fabrica.criarGerenteGeralDao();
    }

    public void adicionarGerenteGeral(GerenteGeral gerenteG) throws SQLException, ParseException {

        gerenteGeralDao.adicionarGerenteGeral(gerenteG);

    }

    public GerenteGeral pesquisarGerenteGeral(String cpf) throws SQLException {
        GerenteGeral gerente = gerenteGeralDao.buscarGerenteGeral(cpf);
        return gerente;
    }

    public void deletarGerenteGeral(String cpf) throws SQLException {
        gerenteGeralDao.removerGerenteGeral(cpf);
    }

    public void alterarGerenteGeral(GerenteGeral gerenteG) throws SQLException, ParseException {

        gerenteGeralDao.atualizarGerenteGeral(gerenteG);
    }
}
