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
import br.edu.ifpb.padroes.interfaces.GerenteDaoIF;
import br.edu.ifpb.padroes.modelo.Agencia;
import br.edu.ifpb.padroes.modelo.Gerente;
import java.util.ArrayList;
import java.util.List;

public class GerenteDao implements GerenteDaoIF {

    Conexao conexao;
    Connection conn;

    public GerenteDao() throws SQLException {
        conexao = new Conexao();
    }

    public void adicionarGerente(Gerente gerente) throws SQLException, ParseException {
        String sql = "INSERT INTO GERENTE (cpf, rg, nome, dataNasc, telefone, email, rua, numCasa"
                + ", bairro, cidade, senha, numAgencia) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

        String dataString = gerente.getDataNasc();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(formato.parse(dataString).getTime());

        try {
            conn = conexao.conectar();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, gerente.getCpf());
            statement.setString(2, gerente.getRg());
            statement.setString(3, gerente.getNome());
            statement.setDate(4, data);
            statement.setString(5, gerente.getTelefone());
            statement.setString(6, gerente.getEmail());
            statement.setString(7, gerente.getRua());
            statement.setString(8, gerente.getNumCasa());
            statement.setString(9, gerente.getBairro());
            statement.setString(10, gerente.getCidade());
            statement.setString(11, gerente.getSenha());
            statement.setString(12, gerente.getAgencia().getNumero());

            statement.execute();
            statement.close();
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public void removerGerente(String cpf) throws SQLException {
        String sql = "DELETE FROM GERENTE WHERE cpf = '" + cpf + "';";
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

    public void atualizarGerente(Gerente gerente) throws SQLException, ParseException {
        String dataString = gerente.getDataNasc();
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = new java.sql.Date(formato.parse(dataString).getTime());

        String sql = "UPDATE GERENTE SET nome = '" + gerente.getNome() + "', dataNasc = '"
                + data + "', telefone = '" + gerente.getTelefone() + "', email = '"
                + gerente.getEmail() + "', rua = '" + gerente.getRua() + "', numCasa = '" + gerente.getNumCasa()
                + "', bairro = '" + gerente.getBairro() + "', cidade = '" + gerente.getCidade() + "', numAgencia = '"
                + gerente.getAgencia().getNumero() + "' WHERE cpf = '" + gerente.getCpf() + "'";
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

    public Gerente buscarGerente(String cpf) throws SQLException {
        String sql = "SELECT * FROM GERENTE WHERE cpf = '" + cpf + "';";
        ResultSet rs;
        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            rs = statement.executeQuery(sql);
            Gerente novoG = new Gerente();
            Agencia agencia = new Agencia();

            while (rs.next()) {
                agencia.setNumero(rs.getString("numAgencia"));

                novoG.setCpf(rs.getString("cpf"));
                novoG.setRg(rs.getString("rg"));
                novoG.setNome(rs.getString("nome"));
                novoG.setDataNasc(rs.getString("dataNasc"));
                novoG.setTelefone(rs.getString("telefone"));
                novoG.setEmail(rs.getString("email"));
                novoG.setRua(rs.getString("rua"));
                novoG.setNumCasa(rs.getString("numCasa"));
                novoG.setBairro(rs.getString("bairro"));
                novoG.setCidade(rs.getString("cidade"));
                novoG.setSenha(rs.getString("senha"));
                novoG.setAgencia(agencia);
            }
            return novoG;
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public List<Gerente> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM GERENTE";
        ResultSet rs;
        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            rs = statement.executeQuery(sql);
            Gerente novoG;
            Agencia agencia = new Agencia();
            List<Gerente> gerentes = new ArrayList();

            while (rs.next()) {
                novoG = new Gerente();
                agencia.setNumero(rs.getString("numAgencia"));

                novoG.setCpf(rs.getString("cpf"));
                novoG.setRg(rs.getString("rg"));
                novoG.setNome(rs.getString("nome"));
                novoG.setDataNasc(rs.getString("dataNasc"));
                novoG.setTelefone(rs.getString("telefone"));
                novoG.setEmail(rs.getString("email"));
                novoG.setRua(rs.getString("rua"));
                novoG.setNumCasa(rs.getString("numCasa"));
                novoG.setBairro(rs.getString("bairro"));
                novoG.setCidade(rs.getString("cidade"));
                novoG.setSenha(rs.getString("senha"));
                novoG.setAgencia(agencia);

                gerentes.add(novoG);
            }
            return gerentes;
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }
}
