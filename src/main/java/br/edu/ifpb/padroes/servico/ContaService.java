package br.edu.ifpb.padroes.servico;

import java.sql.SQLException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.ContaDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Conta;

public class ContaService {

    private DaoFactoryIF fabrica = null;
    private ContaDaoIF contaDao = null;

    public ContaService() throws SQLException {
        fabrica = DaoFactory.createFactory();
        contaDao = fabrica.criaContaDao();
    }

    public Conta abrirConta(Conta conta) throws SQLException {
        conta.setNumero(contaDao.obterNumConta());
        contaDao.salvarConta(conta);
        return conta;
    }

    public Conta pesquisarConta(int numero) throws SQLException {
        Conta conta = contaDao.buscaConta(numero);
        return conta;
    }

    public void deletarConta(int numero) throws SQLException {
        contaDao.removeConta(numero);
    }
}
