package br.edu.ifpb.padroes.gerenciadores;

import java.sql.SQLException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.interfaces.GerenteGeralDaoIF;
import br.edu.ifpb.padroes.modelo.GerenteGeral;
import java.text.ParseException;

public class GerenciadorDeGerenteGeral {

    private DaoFactoryIF fabrica = null;
    private GerenteGeralDaoIF gerenteGeralDao = null;

    public GerenciadorDeGerenteGeral() throws SQLException {
        fabrica = DaoFactory.createFactory();
        gerenteGeralDao = fabrica.criarGerenteGeralDao();
    }

    public void adicionarGerenteGeral(GerenteGeral gerenteG) throws SQLException, ParseException {

        gerenteGeralDao.adicionarGerenteGeral(gerenteG);

    }

    public String pesquisarGerenteGeral(String cpf) throws SQLException {
        GerenteGeral gerente = gerenteGeralDao.buscarGerenteGeral(cpf);
        return gerente.toString();
    }

    public void deletarGerenteGeral(String cpf) throws SQLException {
        gerenteGeralDao.removerGerenteGeral(cpf);
    }

    public void alterarGerenteGeral(GerenteGeral gerenteG) throws SQLException, ParseException {

        gerenteGeralDao.atualizarGerenteGeral(gerenteG);
    }
}
