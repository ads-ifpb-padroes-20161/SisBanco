package br.edu.ifpb.padroes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.edu.ifpb.padroes.conexao.Conexao;
import br.edu.ifpb.padroes.interfaces.AgenciaDaoIF;
import br.edu.ifpb.padroes.modelo.Agencia;
import br.edu.ifpb.padroes.modelo.GerenteGeral;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDao implements AgenciaDaoIF {

    private Conexao conexao;
    private Connection conn;

    public AgenciaDao() throws SQLException {
        conexao = new Conexao();
    }

    public void adicionarAgencia(Agencia agencia) throws SQLException {
        String sql = "INSERT INTO AGENCIA (numero, nome, telefone, rua, numSede, bairro, cidade, cpfGerenteGeral"
                + ") VALUES (?,?,?,?,?,?,?,?);";

        try {
            conn = conexao.conectar();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, agencia.getNumero());
            statement.setString(2, agencia.getNome());
            statement.setString(3, agencia.getTelefone());
            statement.setString(4, agencia.getRua());
            statement.setString(5, agencia.getNumSede());
            statement.setString(6, agencia.getBairro());
            statement.setString(7, agencia.getCidade());
            statement.setString(8, buscarGerente().getCpf());

            statement.execute();
            statement.close();
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public void removerAgencia(String numAgencia) throws SQLException {
        String sql = "DELETE FROM AGENCIA WHERE numero = '" + numAgencia + "';";
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

    public void atualizarAgencia(Agencia agencia) throws SQLException {
        String sql = "UPDATE AGENCIA SET nome = '" + agencia.getNome() + "', telefone = '" + agencia.getTelefone()
                + "', rua = '" + agencia.getRua() + "', numSede = '" + agencia.getNumSede() + "', bairro = '" 
                + agencia.getBairro() + "', cidade = '" + agencia.getCidade() + "', cpfGerenteGeral = '"
                + buscarGerente().getCpf() +"' WHERE numero = '" + agencia.getNumero() + "';";
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

    public Agencia buscarAgencia(String numAgencia) throws SQLException {
        String sql = "SELECT a.numero, a.nome, a.telefone, a.rua, a.numSede, a.bairro, a.cidade, a.cpfGerenteGeral"
                + " FROM AGENCIA a WHERE a.numero = '" + numAgencia + "'";

        ResultSet rs;
        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            rs = statement.executeQuery(sql);
            Agencia agencia = new Agencia();

            while (rs.next()) {
                agencia.setNumero(rs.getString("numero"));
                agencia.setNome(rs.getString("nome"));
                agencia.setTelefone(rs.getString("telefone"));
                agencia.setRua(rs.getString("rua"));
                agencia.setNumSede(rs.getString("numSede"));
                agencia.setBairro(rs.getString("bairro"));
                agencia.setCidade(rs.getString("cidade"));
                agencia.setGerenteG(buscarGerente());

            }
            return agencia;
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public List<Agencia> buscarTodas() throws SQLException {
        String sql = "SELECT * FROM AGENCIA";
        ResultSet rs;
        conn = conexao.conectar();
        Statement statement = conn.createStatement();
        try {

            rs = statement.executeQuery(sql);
            Agencia agencia;
            List<Agencia> agencias = new ArrayList();

            while (rs.next()) {
                agencia = new Agencia();

                agencia.setNumero(rs.getString("numero"));
                agencia.setNome(rs.getString("nome"));
                agencia.setTelefone(rs.getString("telefone"));
                agencia.setRua(rs.getString("rua"));
                agencia.setNumSede(rs.getString("numSede"));
                agencia.setBairro(rs.getString("bairro"));
                agencia.setCidade(rs.getString("cidade"));
                agencia.setGerenteG(buscarGerente());

                agencias.add(agencia);
            }
            return agencias;

        } catch (Exception e) {
            throw new SQLException();
        } finally {
            statement.close();
            conexao.desconectar(conn);
        }
    }

    private GerenteGeral buscarGerente() throws SQLException {

        String sql = "SELECT * FROM GERENTE_GERAL";

        ResultSet rs;
        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            rs = statement.executeQuery(sql);
            GerenteGeral gerente = new GerenteGeral();

            while (rs.next()) {

                gerente.setCpf(rs.getString("cpf"));
                gerente.setRg(rs.getString("rg"));
                gerente.setNome(rs.getString("nome"));
                gerente.setDataNasc(rs.getString("dataNasc"));
                gerente.setTelefone(rs.getString("telefone"));
                gerente.setEmail(rs.getString("email"));
                gerente.setRua(rs.getString("rua"));
                gerente.setNumCasa(rs.getString("numCasa"));
                gerente.setBairro(rs.getString("bairro"));
                gerente.setCidade(rs.getString("cidade"));

            }
            return gerente;
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }
}
