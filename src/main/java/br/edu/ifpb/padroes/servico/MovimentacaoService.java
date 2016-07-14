package br.edu.ifpb.padroes.servico;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.ContaDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.interfaces.MovimentacaoDaoIF;
import br.edu.ifpb.padroes.modelo.Conta;
import br.edu.ifpb.padroes.modelo.Movimentacao;

public class MovimentacaoService {
	
	private DaoFactoryIF fabrica = null;
	private ContaDaoIF contaDao = null;
	private MovimentacaoDaoIF movimentacaoDao = null;
	
	public MovimentacaoService() throws SQLException{
		fabrica = DaoFactory.createFactory();
		contaDao = fabrica.criaContaDao();
		movimentacaoDao = fabrica.criaMovimentacaoDao();
	}
	
	private void creditarSaldo(Conta conta, float valor) throws SQLException{
		float saldo = contaDao.consultarSaldo(conta);
		saldo += valor;
		contaDao.atualizarSaldo(conta, saldo);
	}
	private void debitarSaldo(Conta conta, float valor) throws SQLException{
		float saldo = contaDao.consultarSaldo(conta);
		saldo -= valor;
		contaDao.atualizarSaldo(conta, saldo);
	}
	
	public void realizarDeposito(Movimentacao movimentacao) throws SQLException{
		creditarSaldo(movimentacao.getConta(), movimentacao.getValor());
		movimentacaoDao.salvarMovimentacao(movimentacao);
	}
	
	public void realizarSaque(Movimentacao movimentacao) throws SQLException{
		debitarSaldo(movimentacao.getConta(), movimentacao.getValor());	
		movimentacaoDao.salvarMovimentacao(movimentacao);
	}
	
	public void realizarTransferencia(Movimentacao movimentacao) throws SQLException{
		debitarSaldo(movimentacao.getConta(), movimentacao.getValor());
		creditarSaldo(movimentacao.getDestino(), movimentacao.getValor());
		movimentacaoDao.salvarMovimentacao(movimentacao);
	}
	
	public List<Movimentacao> imprimirExtrato(Conta conta, Date dataInicio, Date dataFim) throws SQLException{
		return movimentacaoDao.extrato(conta, dataInicio, dataFim);
	}
}