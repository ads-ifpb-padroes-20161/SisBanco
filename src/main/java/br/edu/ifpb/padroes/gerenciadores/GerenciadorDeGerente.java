package br.edu.ifpb.padroes.gerenciadores;

import java.sql.SQLException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.interfaces.GerenteDaoIF;
import br.edu.ifpb.padroes.modelo.Gerente;
import java.text.ParseException;

public class GerenciadorDeGerente {

    private DaoFactoryIF fabrica = null;
    private GerenteDaoIF gerenteDao = null;

    public GerenciadorDeGerente() throws SQLException {
        fabrica = DaoFactory.createFactory();
        gerenteDao = fabrica.criarGerenteDao();
    }

    public void adicionarGerente(Gerente gerente) throws SQLException, ParseException {

        gerenteDao.adicionarGerente(gerente);

    }

    public String pesquisarGerente(String cpf) throws SQLException {
        Gerente gerente = gerenteDao.buscarGerente(cpf);
        return gerente.toString();
    }

    public void deletarGerente(String cpf) throws SQLException {
        gerenteDao.removerGerente(cpf);
    }

    public void alterarGerente(Gerente gerente) throws SQLException, ParseException {

        gerenteDao.atualizarGerente(gerente);
    }
}
