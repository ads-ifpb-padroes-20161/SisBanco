package br.edu.ifpb.padroes.dao;

import br.edu.ifpb.padroes.interfaces.ContaClienteDaoIF;
import br.edu.ifpb.padroes.modelo.ContaCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ContaClienteDao implements ContaClienteDaoIF {

    public ContaClienteDao() {

    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Banco", "postgres", "12345");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void adicionarContaCliente(ContaCliente contaCliente) throws SQLException {
        String sql = "INSERT INTO CONTA_CLIENTE(cpf_cnpj, numConta) VALUES(?,?);";
        Connection c = this.getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(sql);

            ps.setString(1, contaCliente.getCpf());
            ps.setString(2, contaCliente.getNumConta());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {;
                }
                ps = null;
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {;
                }
                c = null;
            }
        }

    }

    public void removerContaCliente(String cpf) throws SQLException {
        String sql = "DELETE FROM CONTA_CLIENTE WHERE cpf = '" + cpf + "';";

        Connection c = this.getConnection();
        Statement statement = null;
        try {
            statement = c.createStatement();

            statement.executeUpdate(sql);

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {;
                }
                statement = null;
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {;
                }
                c = null;
            }
        }
    }
}
