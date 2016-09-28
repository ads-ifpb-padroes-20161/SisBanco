package br.edu.ifpb.padroes.gerenciadores;

import java.sql.SQLException;

import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.AgenciaDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Agencia;

public class GerenciadorDeAgencia {

    private DaoFactoryIF fabrica = null;
    private AgenciaDaoIF agenciaDao = null;

    public GerenciadorDeAgencia() throws SQLException {
        fabrica = DaoFactory.createFactory();
        agenciaDao = fabrica.criarAgenciaDao();
    }

    public void adicionarAgencia(Agencia agencia) throws SQLException {

        agenciaDao.adicionarAgencia(agencia);
    }

    public String pesquisarAgencia(String numero) throws SQLException {
        Agencia ag = agenciaDao.buscarAgencia(numero);
        return ag.toString();
    }

    public void deletarAgencia(String numero) throws SQLException {
        agenciaDao.removerAgencia(numero);
    }

    public void alterarAgencia(Agencia agencia) throws SQLException {

        agenciaDao.atualizarAgencia(agencia);
    }
}
