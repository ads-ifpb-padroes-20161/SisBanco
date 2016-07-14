package br.edu.ifpb.padroes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import br.edu.ifpb.padroes.conexao.Conexao;
import br.edu.ifpb.padroes.interfaces.AdministradorDaoIF;
import br.edu.ifpb.padroes.modelo.Administrador;

public class AdministradorDao implements AdministradorDaoIF{
	Conexao conexao;
	Connection conn;
	
	public AdministradorDao() throws SQLException{
		conexao = new Conexao();
	}
	
	public void addAdministrador(Administrador admin) throws Exception {
		String sql = "INSERT INTO ADMINISTRADOR (cpf, rg, nome, dataNasc, telefone, email, rua, numCasa"
				+ ", bairro, cidade, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		
		String dataString = admin.getDataNasc();
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = new java.sql.Date(formato.parse(dataString).getTime());
		
		try{
			conn = conexao.conectar();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			
			statement.setString(1, admin.getCpf());
			statement.setString(2, admin.getRg());
			statement.setString(3, admin.getNome());
			statement.setDate(4, (java.sql.Date) data);
			statement.setString(5, admin.getTelefone());
			statement.setString(6, admin.getEmail());
			statement.setString(7, admin.getRua());
			statement.setInt(8, admin.getNumCasa());
			statement.setString(9, admin.getBairro());
			statement.setString(10, admin.getCidade());
			statement.setString(11, admin.getSenha());
			
			statement.execute();
			statement.close();
		}
		catch(Exception e){
			throw e;
		}
		finally{
			conexao.desconectar(conn);
		}
	}

	public void removeAdministrador(String cpf) throws SQLException {
		String sql = "DELETE FROM ADMINISTRADOR WHERE cpf = '" + cpf + "';";
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

	public void atualizarAdministrador(Administrador admin) throws Exception {
		
		String dataString = admin.getDataNasc();
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = new java.sql.Date(formato.parse(dataString).getTime());
		
		String sql = "UPDATE ADMINISTRADOR SET nome = '" + admin.getNome() +  "', dataNasc = '" + 
				data + "', telefone = '"+ admin.getTelefone() + "', email = '"
				+ admin.getEmail() + "', rua = '" + admin.getRua() + "', numCasa = '" + admin.getNumCasa() 
				+ "', bairro = '" + admin.getBairro() + "', cidade = '" + admin.getCidade() + "';";
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

	public Administrador buscaAdministrador(String cpf) throws SQLException {
		String sql = "SELECT * FROM ADMINISTRADOR WHERE cpf ILIKE '" + cpf + "';";
		ResultSet rs;
		try{
			conn = conexao.conectar();
			Statement statement = conn.createStatement();
			
			rs = statement.executeQuery(sql);
			Administrador novoA = new Administrador();
			
			while(rs.next()){
				novoA.setCpf(rs.getString("cpf"));
				novoA.setRg(rs.getString("rg"));
				novoA.setNome(rs.getString("nome"));
				novoA.setDataNasc(rs.getString("dataNasc"));
				novoA.setTelefone(rs.getString("telefone"));
				novoA.setEmail(rs.getString("email"));
				novoA.setRua(rs.getString("rua"));
				novoA.setNumCasa(rs.getInt("numCasa"));
				novoA.setBairro(rs.getString("bairro"));
				novoA.setCidade(rs.getString("cidade"));
				novoA.setSenha(rs.getString("senha"));
			}
			return novoA;
		}
		catch(Exception e){
			throw new SQLException(e);
		}
		finally{
			conexao.desconectar(conn);
		}
	}
}