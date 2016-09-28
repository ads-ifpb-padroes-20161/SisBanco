package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import br.edu.ifpb.padroes.modelo.Conta;
import br.edu.ifpb.padroes.modelo.MovimentacaoFinanceira;

public interface MovimentacaoDaoIF {

    public void salvarMovimentacao(MovimentacaoFinanceira movimentacao) throws SQLException;

    public List<MovimentacaoFinanceira> extrato(Conta conta, Date dataInicio, Date dataFim) throws SQLException;

    public int obterUltimoNum() throws SQLException;

    public float somar(String tipo) throws SQLException;
}
