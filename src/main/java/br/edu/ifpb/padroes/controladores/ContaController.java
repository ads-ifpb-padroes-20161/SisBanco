package br.edu.ifpb.padroes.controladores;

import java.sql.SQLException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.ContaDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Conta;

public class ContaController {

    private DaoFactoryIF fabrica = null;
    private ContaDaoIF contaDao = null;

    public ContaController() throws SQLException {
        fabrica = DaoFactory.createFactory();
        contaDao = fabrica.criarContaDao();
    }

    public void abrirConta(Conta conta) throws SQLException {

        contaDao.adicionarConta(conta);

    }

    public Conta pesquisarConta(String numero) throws SQLException {
        Conta conta = contaDao.buscarConta(numero);
        return conta;
    }

    public void deletarConta(String numero) throws SQLException {
        contaDao.removerConta(numero);
    }
}
