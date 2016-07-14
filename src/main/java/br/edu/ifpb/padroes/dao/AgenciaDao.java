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

    public void addAgencia(Agencia agencia) throws SQLException {
        String sql = "INSERT INTO AGENCIA (numero, nome, telefone, rua, numSede, bairro, cidade, cpfGerenteGeral"
                + ") VALUES (?,?,?,?,?,?,?);";

        try {
            conn = conexao.conectar();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, agencia.getNumero());
            statement.setString(2, agencia.getNome());
            statement.setString(3, agencia.getTelefone());
            statement.setString(4, agencia.getRua());
            statement.setInt(5, agencia.getNumSede());
            statement.setString(6, agencia.getBairro());
            statement.setString(7, agencia.getCidade());
            statement.setString(8, agencia.getGerenteG().getCpf());

            statement.execute();
            statement.close();
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public void removerAgencia(int numAgencia) throws SQLException {
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
        String sql = "UPDATE AGENCIA SET nome = '" + agencia.getNome() + "', telefone = '"
                + agencia.getTelefone() + "', rua = '" + agencia.getRua() + "', numSede = '" + agencia.getNumSede()
                + "', bairro = '" + agencia.getBairro() + "', cidade = '" + agencia.getCidade() + "';";
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

    public Agencia buscarAgencia(int numAgencia) throws SQLException {
        String sql = "SELECT a.numero, a.nome, a.telefone, a.rua, a.numSede, a.bairro, a.cidade"
                + "g.cpf, g.rg, g.nome nomeGerente, g.dataNasc, g.telefone telGerente, g.email"
                + "g.rua ruaGerente, g.numCasa, g.bairro bairroGerente, g.cidade gerenteCidade"
                + " FROM AGENCIA a, GERENTE g"
                + "WHERE a.numero = '" + numAgencia + "'"
                + "AND a.cpfGerenteGeral = g.cpf";

        ResultSet rs;
        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            rs = statement.executeQuery(sql);
            Agencia agencia = new Agencia();
            GerenteGeral gerente = new GerenteGeral();

            while (rs.next()) {
                agencia.setNumero(rs.getInt("numero"));
                agencia.setNome(rs.getString("nome"));
                agencia.setTelefone(rs.getString("telefone"));
                agencia.setRua(rs.getString("rua"));
                agencia.setNumSede(rs.getInt("numSede"));
                agencia.setBairro(rs.getString("bairro"));
                agencia.setCidade(rs.getString("cidade"));
                agencia.setGerenteG(gerente);

                gerente.setCpf(rs.getString("cpfGerenteGeral"));

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
            GerenteGeral gerenteG = new GerenteGeral();
            List<Agencia> agencias = new ArrayList();
            while (rs.next()) {
                agencia = new Agencia();

                agencia.setNumero(rs.getInt("numero"));
                agencia.setNome(rs.getString("nome"));
                agencia.setTelefone(rs.getString("telefone"));
                agencia.setRua(rs.getString("rua"));
                agencia.setNumSede(rs.getInt("numSede"));
                agencia.setBairro(rs.getString("bairro"));
                agencia.setCidade(rs.getString("cidade"));
                agencia.setGerenteG(gerenteG);

                gerenteG.setCpf(rs.getString("cpfGerenteGeral"));
                
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
}
