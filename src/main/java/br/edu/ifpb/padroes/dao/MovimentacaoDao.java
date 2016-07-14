package br.edu.ifpb.padroes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.edu.ifpb.padroes.conexao.Conexao;
import br.edu.ifpb.padroes.interfaces.MovimentacaoDaoIF;
import br.edu.ifpb.padroes.modelo.Administrador;
import br.edu.ifpb.padroes.modelo.Cliente;
import br.edu.ifpb.padroes.modelo.Conta;
import br.edu.ifpb.padroes.modelo.Movimentacao;

public class MovimentacaoDao implements MovimentacaoDaoIF{

	private Conexao conexao;
	private Connection conn;
	
	public MovimentacaoDao() throws SQLException{
		conexao = new Conexao();
	}
	
	public void salvarMovimentacao(Movimentacao movimentacao) throws SQLException {
		String sql = "INSERT INTO MOVIMENTACAO (numConta, cpf_cnpj, cpfAdmin, valor, dataHora) VALUES (?, ?, ?, ?, ?)";
		
		try{
			conn = conexao.conectar();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, movimentacao.getConta().getNumero());
			statement.setString(1, movimentacao.getCliente().getCpf_cnpj());
			
			if(movimentacao.getAdmin().getCpf() == null){
				statement.setString(3, null);
			}else{
				statement.setString(3, movimentacao.getAdmin().getCpf());
			}
			statement.setFloat(4, movimentacao.getValor());
			statement.setDate(5, (java.sql.Date) movimentacao.getDataHora());
			
			statement.execute();
			statement.close();
			
		}catch(Exception e){	
			throw new SQLException(e);
		
		}finally{
			conexao.desconectar(conn);
		}
	}

	public List<Movimentacao> extrato(Conta conta, Date dataInicio, Date dataFim) throws SQLException {
		String sql = "SELECT ct.numero, cl.cpf_cnpj, a.cpf, m.valor, m.dataHora, m.tipo"
				+ " FROM  CONTA ct, CLIENTE cl, ADMINISTRADOR a, MOVIMENTACAO m"
				+ " WHERE m.numConta = '" + conta.getNumero() + "' AND dataHora BETWEEN ? AND ?";
		
		ResultSet rs;
		
		try{
			conn = conexao.conectar();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setDate(1, (java.sql.Date) dataInicio);
			statement.setDate(12, (java.sql.Date) dataFim);
			
			rs = statement.executeQuery();
			
			Cliente cliente = new Cliente();
			Administrador admin = new Administrador();
			List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
			
			while(rs.next()){
				Movimentacao movimentacao = new Movimentacao();
				movimentacao.setConta(conta);
				movimentacao.setCliente(cliente);
				movimentacao.setAdmin(admin);
				movimentacao.setValor(rs.getFloat("valor"));
				movimentacao.setDataHora(rs.getDate("dataHora"));
				movimentacao.setTipoMovimentacao(rs.getString("tipo"));
				
				cliente.setCpf_cnpj(rs.getString("cpf_cnpj"));
				admin.setCpf(rs.getString("cpf"));
				
				movimentacoes.add(movimentacao);
			}
			return movimentacoes;
			
		}catch(Exception e){
			throw new SQLException(e);
			
		}finally{
			conexao.desconectar(conn);
		}			
	}
}