package br.edu.ifpb.padroes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.edu.ifpb.padroes.conexao.Conexao;
import br.edu.ifpb.padroes.interfaces.ContaDaoIF;
import br.edu.ifpb.padroes.modelo.Agencia;
import br.edu.ifpb.padroes.modelo.Cliente;
import br.edu.ifpb.padroes.modelo.Conta;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ContaDao implements ContaDaoIF {

    Conexao conexao;
    Connection conn;

    public ContaDao() throws SQLException {
        conexao = new Conexao();
    }

    public void adicionarConta(Conta conta) throws SQLException {
        String sql = "INSERT INTO CONTA (numero, saldo, dataAbertura, numAgencia) VALUES (?, ?, ?, ?);";
        try {
            conn = conexao.conectar();
            PreparedStatement statement = conn.prepareStatement(sql);

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

            String data = df.format(conta.getDataAbertura());

            java.sql.Date data2 = new java.sql.Date(df.parse(data).getTime());

            statement.setString(1, conta.getNumero());
            statement.setFloat(2, conta.getSaldo());
            statement.setDate(3, data2);
            statement.setString(4, conta.getAgencia().getNumero());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (ParseException e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public void removerConta(String numero) throws SQLException {
        String sql = "DELETE FROM CONTA WHERE numero = '" + numero + "';";
        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            statement.executeUpdate(sql);

            statement.close();
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public Conta buscarConta(String numero) throws SQLException {
        String sql = "SELECT c.numero, c.saldo, c.dataAbertura, a.numero numAgencia"
                + " FROM CONTA c, AGENCIA a WHERE c.numero = '" + numero + "';";
        ResultSet rs;
        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            rs = statement.executeQuery(sql);
            Conta conta = new Conta();
            Agencia agencia = new Agencia();

            while (rs.next()) {
                conta.setNumero(rs.getString("numero"));
                conta.setSaldo(rs.getFloat("saldo"));
                conta.setDataAbertura(rs.getDate("dataAbertura"));
                conta.setAgencia(agencia);

                agencia.setNumero(rs.getString("numAgencia"));
            }
            return conta;
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public List<Conta> buscarTodas() throws SQLException {
        String sql = "SELECT * FROM CONTA";
        ResultSet rs;
        conn = conexao.conectar();
        Statement statement = conn.createStatement();

        try {

            rs = statement.executeQuery(sql);
            Conta conta;
            Agencia agencia = new Agencia();
            List<Conta> contas = new ArrayList();
            while (rs.next()) {
                conta = new Conta();

                conta.setNumero(rs.getString("numero"));
                conta.setDataAbertura(rs.getDate("dataAbertura"));
                conta.setSaldo(rs.getFloat("saldo"));
                conta.setAgencia(agencia);

                agencia.setNumero(rs.getString("numAgencia"));

                contas.add(conta);
            }
            return contas;

        } catch (Exception e) {
            throw new SQLException();
        } finally {
            statement.close();
            conexao.desconectar(conn);
        }
    }

    public List<Conta> buscarPorAgencia(String numAgencia) throws SQLException {
        String sql = "SELECT * FROM CONTA WHERE numAgencia ='" + numAgencia + "'";
        ResultSet rs;
        conn = conexao.conectar();
        Statement statement = conn.createStatement();

        try {

            rs = statement.executeQuery(sql);
            Conta conta;
            Agencia agencia = new Agencia();
            List<Conta> contas = new ArrayList();
            while (rs.next()) {
                conta = new Conta();

                conta.setNumero(rs.getString("numero"));
                conta.setDataAbertura(rs.getDate("dataAbertura"));
                conta.setSaldo(rs.getFloat("saldo"));
                conta.setAgencia(agencia);

                agencia.setNumero(rs.getString("numAgencia"));

                contas.add(conta);
            }
            return contas;

        } catch (Exception e) {
            throw new SQLException();
        } finally {
            statement.close();
            conexao.desconectar(conn);
        }
    }

    public int obterNumConta() throws SQLException {
        String sql = "SELECT MAX(numero) maior FROM CONTA";

        ResultSet rs = null;
        Statement statement = null;
        conn = conexao.conectar();
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            if (rs.next()) {
                int maior = rs.getInt("maior");
                return ++maior;
            }
            return 1;
        } finally {
            rs.close();
            statement.close();
            conexao.desconectar(conn);
        }
    }

    public void atualizarSaldo(Conta conta, float valor) throws SQLException {
        String sql = "UPDATE CONTA c SET saldo = '" + valor + "' WHERE c.numero = '" + conta.getNumero() + "'";

        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            throw new SQLException(e);

        } finally {
            conexao.desconectar(conn);
        }
    }

    public float consultarSaldo(Conta conta) throws SQLException {
        String sql = "SELECT saldo FROM CONTA c WHERE c.numero = '" + conta.getNumero() + "'";
        ResultSet rs;

        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            rs = statement.executeQuery(sql);
            float saldo = 0;
            while (rs.next()) {
                saldo = rs.getFloat("saldo");

            }
            rs.close();
            return saldo;

        } catch (Exception e) {
            throw new SQLException(e);
        } finally {

            conexao.desconectar(conn);
        }

    }

    public List<Cliente> buscarTitulares(String numConta) throws SQLException {
        String sql = "SELECT distinct cli.cpf_cnpj,cli.nome FROM CONTA c, CLIENTE cli, CONTA_CLIENTE cc"
                + " WHERE cc.numConta = '" + numConta + "' AND cc.cpf_cnpj = cli.cpf_cnpj";
        ResultSet rs;
        conn = conexao.conectar();
        Statement statement = conn.createStatement();

        try {

            rs = statement.executeQuery(sql);
            Cliente cliente;
            List<Cliente> clientes = new ArrayList();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCpf_cnpj(rs.getString("cpf_cnpj"));
                cliente.setNome(rs.getString("nome"));

                clientes.add(cliente);
            }
            return clientes;

        } catch (Exception e) {
            throw new SQLException();
        } finally {
            statement.close();
            conexao.desconectar(conn);
        }
    }
}
