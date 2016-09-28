package br.edu.ifpb.padroes.controladores;

import java.sql.SQLException;

import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.AgenciaDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Agencia;

public class AgenciaController {

    private DaoFactoryIF fabrica = null;
    private AgenciaDaoIF agenciaDao = null;

    public AgenciaController() throws SQLException {
        fabrica = DaoFactory.createFactory();
        agenciaDao = fabrica.criarAgenciaDao();
    }

    public void adicionarAgencia(Agencia agencia) throws SQLException {

        agenciaDao.adicionarAgencia(agencia);
    }

    public Agencia pesquisarAgencia(String numero) throws SQLException {
        Agencia ag = agenciaDao.buscarAgencia(numero);
        return ag;
    }

    public void deletarAgencia(String numero) throws SQLException {
        agenciaDao.removerAgencia(numero);
    }

    public void alterarAgencia(Agencia agencia) throws SQLException {

        agenciaDao.atualizarAgencia(agencia);
    }
}
