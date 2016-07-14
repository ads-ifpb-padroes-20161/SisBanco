package br.edu.ifpb.padroes.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	Connection conn;
	public Connection conectar() throws SQLException {

		String url = "jdbc:postgresql://127.0.0.1:5432/sisBanco";
		String user = "postgres";
		String password = "12345";
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	public void desconectar(Connection conn) throws SQLException{
		this.conn.close();
	}
}
