package br.edu.ifpb.padroes.gerenciadores;

import java.sql.SQLException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.ContaDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Conta;

public class GerenciadorDeConta {

    private DaoFactoryIF fabrica = null;
    private ContaDaoIF contaDao = null;

    public GerenciadorDeConta() throws SQLException {
        fabrica = DaoFactory.createFactory();
        contaDao = fabrica.criarContaDao();
    }

    public void adicionarConta(Conta conta) throws SQLException {

        contaDao.adicionarConta(conta);
    }

    public String pesquisarConta(String numero) throws SQLException {
        Conta conta = contaDao.buscarConta(numero);
        return conta.toString();
    }

    public void deletarConta(String numero) throws SQLException {
        contaDao.removerConta(numero);
    }

}
