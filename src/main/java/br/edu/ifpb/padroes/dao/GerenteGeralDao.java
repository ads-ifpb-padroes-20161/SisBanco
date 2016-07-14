package br.edu.ifpb.padroes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.edu.ifpb.padroes.conexao.Conexao;
import br.edu.ifpb.padroes.interfaces.GerenteGeralDaoIF;
import br.edu.ifpb.padroes.modelo.GerenteGeral;

public class GerenteGeralDao implements GerenteGeralDaoIF{
	Conexao conexao;
	Connection conn;
	
	public GerenteGeralDao() throws SQLException{
		conexao = new Conexao();
	}

	public void addGerenteGeral(GerenteGeral gGeral) throws SQLException, ParseException {
		String sql = "INSERT INTO GERENTE_GERAL (cpf, rg, nome, dataNasc, telefone, email, rua, numCasa"
				+ ", bairro, cidade, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		
		String dataString = gGeral.getDataNasc();
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = new java.sql.Date(formato.parse(dataString).getTime());
		
		try{
			conn = conexao.conectar();
			PreparedStatement statement = conn.prepareStatement(sql);
		
			statement.setString(1, gGeral.getCpf());
			statement.setString(2, gGeral.getRg());
			statement.setString(3, gGeral.getNome());
			statement.setDate(4, data);
			statement.setString(5, gGeral.getTelefone());
			statement.setString(6, gGeral.getEmail());
			statement.setString(7, gGeral.getRua());
			statement.setInt(8, gGeral.getNumCasa());
			statement.setString(9, gGeral.getBairro());
			statement.setString(10, gGeral.getCidade());
			statement.setString(11, gGeral.getSenha());
			
			statement.execute();
			statement.close();
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		finally{
			conexao.desconectar(conn);
		}
	}

	public void removeGerenteGeral(String cpf) throws SQLException {
		String sql = "DELETE FROM GERENTE_GERAL WHERE cpf = '" + cpf + "';";
		try{
			conn = conexao.conectar();
			Statement statement = conn.createStatement();
			
			statement.executeUpdate(sql);
			
			statement.close();
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		finally{
			conexao.desconectar(conn);
		}
	}

	public void atualizarGerenteGeral(GerenteGeral gGeral) throws SQLException, ParseException {
		String dataString = gGeral.getDataNasc();
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = new java.sql.Date(formato.parse(dataString).getTime());
		
		String sql = "UPDATE GERENTE_GERAL SET nome = '" + gGeral.getNome() +  "', dataNasc = '" + 
				data + "', telefone = '"+ gGeral.getTelefone() + "', email = '"
				+ gGeral.getEmail() + "', rua = '" + gGeral.getRua() + "', numCasa = '" + gGeral.getNumCasa() 
				+ "', bairro = '" + gGeral.getBairro() + "', cidade = '" + gGeral.getCidade()+"';";
		try{
			conn = conexao.conectar();
			Statement statement = conn.createStatement();
			
			statement.executeUpdate(sql);
			
			statement.close();
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		finally{
			conexao.desconectar(conn);
		}
	}

	public GerenteGeral buscaGerenteGeral(String cpf) throws SQLException {
		String sql = "SELECT * FROM GERENTE_GERAL WHERE cpf = '" + cpf + "';";
		ResultSet rs;
		try{
			conn = conexao.conectar();
			Statement statement = conn.createStatement();
			
			rs = statement.executeQuery(sql);
			GerenteGeral novoGG = new GerenteGeral();
			
			while(rs.next()){
				novoGG.setCpf(rs.getString("cpf"));
				novoGG.setRg(rs.getString("rg"));
				novoGG.setNome(rs.getString("nome"));
				novoGG.setDataNasc(rs.getString("dataNasc"));
				novoGG.setTelefone(rs.getString("telefone"));
				novoGG.setEmail(rs.getString("email"));
				novoGG.setRua(rs.getString("rua"));
				novoGG.setNumCasa(rs.getInt("numCasa"));
				novoGG.setBairro(rs.getString("bairro"));
				novoGG.setCidade(rs.getString("cidade"));
				novoGG.setSenha(rs.getString("senha"));
			}
			return novoGG;
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		finally{
			conexao.desconectar(conn);
		}
	}
}