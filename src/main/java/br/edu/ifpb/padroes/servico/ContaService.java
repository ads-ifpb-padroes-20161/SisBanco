package br.edu.ifpb.padroes.servico;

import java.sql.SQLException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.ContaDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Cliente;
import br.edu.ifpb.padroes.modelo.Conta;
import java.util.List;

public class ContaService {

    private DaoFactoryIF fabrica = null;
    private ContaDaoIF contaDao = null;

    public ContaService() throws SQLException {
        fabrica = DaoFactory.createFactory();
        contaDao = fabrica.criarContaDao();
    }

    public Conta abrirConta(Conta conta) throws SQLException {

        conta.setNumero("" + contaDao.obterNumConta());
        contaDao.adicionarConta(conta);
        return conta;
    }

    public Conta pesquisarConta(String numero) throws SQLException {
        Conta conta = contaDao.buscarConta(numero);
        return conta;
    }

    public List<Conta> listarTodas() throws SQLException {
        return contaDao.buscarTodas();
    }

    public List<Conta> listarPorAgencia(String numAgencia) throws SQLException {
        return contaDao.buscarPorAgencia(numAgencia);
    }

    public void deletarConta(String numero) throws SQLException {
        contaDao.removerConta(numero);
    }

    public List<Cliente> buscarTitulares(String numConta) throws SQLException {
        return contaDao.buscarTitulares(numConta);
    }
}
