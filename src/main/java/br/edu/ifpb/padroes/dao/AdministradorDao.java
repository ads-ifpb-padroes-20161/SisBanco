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
import java.util.ArrayList;
import java.util.List;

public class AdministradorDao implements AdministradorDaoIF {

    Conexao conexao;
    Connection conn;

    public AdministradorDao() throws SQLException {
        conexao = new Conexao();
    }

    public void adicionarAdministrador(Administrador admin) throws Exception {
        String sql = "INSERT INTO ADMINISTRADOR (cpf, rg, nome, dataNasc, telefone, email, rua, numCasa"
                + ", bairro, cidade, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?);";

        String dataString = admin.getDataNasc();
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());

        try {
            conn = conexao.conectar();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, admin.getCpf());
            statement.setString(2, admin.getRg());
            statement.setString(3, admin.getNome());
            statement.setDate(4, data);
            statement.setString(5, admin.getTelefone());
            statement.setString(6, admin.getEmail());
            statement.setString(7, admin.getRua());
            statement.setString(8, admin.getNumCasa());
            statement.setString(9, admin.getBairro());
            statement.setString(10, admin.getCidade());
            statement.setString(11, admin.getSenha());

            statement.execute();
            statement.close();
        } catch (Exception e) {
            throw e;
        } finally {
            conexao.desconectar(conn);
        }
    }

    public void removerAdministrador(String cpf) throws SQLException {
        String sql = "DELETE FROM ADMINISTRADOR WHERE cpf = '" + cpf + "';";
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

    public void atualizarAdministrador(Administrador admin) throws Exception {

        String dataString = admin.getDataNasc();
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());

        String sql = "UPDATE ADMINISTRADOR SET "
                + "nome = '" + admin.getNome() + "'"
                + ",dataNasc = '" + data + "'"
                + ",telefone = '" + admin.getTelefone() + "'"
                + ",email = '" + admin.getEmail() + "'"
                + ",rua = '" + admin.getRua() + "'"
                + ",numCasa = '" + admin.getNumCasa() + "'"
                + ",bairro = '" + admin.getBairro() + "'"
                + ",cidade = '" + admin.getCidade() + "'"
                + "WHERE cpf = '" + admin.getCpf() + "'";

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

    public Administrador buscarAdministrador(String cpf) throws SQLException {
        String sql = "SELECT * FROM ADMINISTRADOR WHERE cpf = '" + cpf + "';";
        ResultSet rs;
        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            rs = statement.executeQuery(sql);
            Administrador novoA = new Administrador();

            while (rs.next()) {
                novoA.setCpf(rs.getString("cpf"));
                novoA.setRg(rs.getString("rg"));
                novoA.setNome(rs.getString("nome"));
                novoA.setDataNasc(rs.getString("dataNasc"));
                novoA.setTelefone(rs.getString("telefone"));
                novoA.setEmail(rs.getString("email"));
                novoA.setRua(rs.getString("rua"));
                novoA.setNumCasa(rs.getString("numCasa"));
                novoA.setBairro(rs.getString("bairro"));
                novoA.setCidade(rs.getString("cidade"));
                novoA.setSenha(rs.getString("senha"));
            }
            return novoA;
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public List<Administrador> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM ADMINISTRADOR";
        ResultSet rs;
        conn = conexao.conectar();
        Statement statement = conn.createStatement();

        try {

            rs = statement.executeQuery(sql);
            Administrador administrador;

            List<Administrador> administradores = new ArrayList();
            while (rs.next()) {
                administrador = new Administrador();

                administrador.setCpf(rs.getString("cpf"));
                administrador.setRg(rs.getString("rg"));
                administrador.setNome(rs.getString("nome"));
                administrador.setDataNasc(rs.getString("dataNasc"));
                administrador.setTelefone(rs.getString("telefone"));
                administrador.setEmail(rs.getString("email"));
                administrador.setRua(rs.getString("rua"));
                administrador.setNumCasa(rs.getString("numCasa"));
                administrador.setBairro(rs.getString("bairro"));
                administrador.setCidade(rs.getString("cidade"));
                administrador.setSenha(rs.getString("senha"));

                administradores.add(administrador);
            }
            return administradores;

        } catch (Exception e) {
            throw new SQLException();
        } finally {
            statement.close();
            conexao.desconectar(conn);
        }
    }
}
