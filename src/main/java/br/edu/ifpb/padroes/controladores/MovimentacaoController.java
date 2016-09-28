package br.edu.ifpb.padroes.controladores;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.ContaDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.interfaces.MovimentacaoDaoIF;
import br.edu.ifpb.padroes.modelo.Conta;
import br.edu.ifpb.padroes.modelo.MovimentacaoFinanceira;

public class MovimentacaoController {

    private DaoFactoryIF fabrica = null;
    private ContaDaoIF contaDao = null;
    private MovimentacaoDaoIF movimentacaoDao = null;

    public MovimentacaoController() throws SQLException {
        fabrica = DaoFactory.createFactory();
        contaDao = fabrica.criarContaDao();
        movimentacaoDao = fabrica.criarMovimentacaoDao();
    }

    private void creditarSaldo(Conta conta, float valor) throws SQLException {
        float saldo = contaDao.consultarSaldo(conta);
        saldo += valor;
        contaDao.atualizarSaldo(conta, saldo);
    }

    private void debitarSaldo(Conta conta, float valor) throws SQLException {
        float saldo = contaDao.consultarSaldo(conta);
        saldo -= valor;
        contaDao.atualizarSaldo(conta, saldo);
    }

    public void realizarDeposito(MovimentacaoFinanceira movimentacao) throws SQLException {
        creditarSaldo(movimentacao.getConta(), movimentacao.getValor());
        movimentacaoDao.salvarMovimentacao(movimentacao);
    }

    public void realizarSaque(MovimentacaoFinanceira movimentacao) throws SQLException {
        debitarSaldo(movimentacao.getConta(), movimentacao.getValor());
        movimentacaoDao.salvarMovimentacao(movimentacao);
    }

    public void realizarTransferencia(MovimentacaoFinanceira movimentacao) throws SQLException {
        debitarSaldo(movimentacao.getConta(), movimentacao.getValor());
        creditarSaldo(movimentacao.getConta(), movimentacao.getValor());
        movimentacaoDao.salvarMovimentacao(movimentacao);
    }

    public List<MovimentacaoFinanceira> imprimirExtrato(Conta conta, Date dataInicio, Date dataFim) throws SQLException {
        return movimentacaoDao.extrato(conta, dataInicio, dataFim);
    }
}
