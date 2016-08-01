package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import br.edu.ifpb.padroes.modelo.Conta;
import br.edu.ifpb.padroes.modelo.Movimentacao;

public interface MovimentacaoDaoIF {
	
	public void salvarMovimentacao(Movimentacao movimentacao) throws SQLException;
        
	public List<Movimentacao> extrato(Conta conta, Date dataInicio, Date dataFim) throws SQLException;
}