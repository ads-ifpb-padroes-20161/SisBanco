package br.edu.ifpb.padroes.dao;

import br.edu.ifpb.padroes.conexao.Conexao;
import br.edu.ifpb.padroes.enums.TipoConta;
import br.edu.ifpb.padroes.interfaces.ContaUsuarioDaoIF;
import br.edu.ifpb.padroes.modelo.ContaUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContaUsuarioDao implements ContaUsuarioDaoIF {

    private Conexao conexao;
    private Connection conn;

    public ContaUsuarioDao() {
        conexao = new Conexao();
    }

    public void adicionarContaUsuario(ContaUsuario contaUsuario) throws SQLException {
        String sql = "INSERT INTO CONTA_USUARIO(cpf, senha, tipoConta" + ") VALUES(?,?,?);";
        try {
            conn = conexao.conectar();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, contaUsuario.getCpf());
            statement.setString(2, contaUsuario.getSenha());
            statement.setString(3, contaUsuario.getTipoConta().toString());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public void removerContaUsuario(String cpf) throws SQLException {
        String sql = "DELETE FROM CONTA_USUARIO WHERE numero = '" + cpf + "';";
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

    public void atualizarContaUsuario(ContaUsuario contaUsuario) throws SQLException {
        String sql = "UPDATE CONTA_USUARIO SET cpf = '" + contaUsuario.getCpf() + "', senha = '"
                + contaUsuario.getSenha() + "', tipoConta = '" + contaUsuario.getTipoConta() + "';";
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

    public ContaUsuario buscarContaUsuario(String cpf) throws SQLException {
        String sql = "SELECT cu.cpf, cu.senha, cu.tipoConta"
                + "FROM CONTA_USUARIO cu"
                + "WHRE cu.cpf='" + cpf + "';";
        ResultSet rs;
        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            rs = statement.executeQuery(sql);
            ContaUsuario contaUsuario = new ContaUsuario();

            while (rs.next()) {
                contaUsuario.setCpf(rs.getString("cpf"));
                contaUsuario.setSenha(rs.getString("senha"));
                TipoConta tc = TipoConta.valueOf(rs.getString("tipoConta"));
                contaUsuario.setTipoConta(tc);
            }
            return contaUsuario;
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public List<ContaUsuario> buscarTodas() throws SQLException {
        String sql = "SELECT * FROM CONTA_USUARIO";
        ResultSet rs;
        conn = conexao.conectar();
        Statement statement = conn.createStatement();
        try {

            rs = statement.executeQuery(sql);
            ContaUsuario contaUsuario;
            List<ContaUsuario> usuarios = new ArrayList();
            while (rs.next()) {
                contaUsuario = new ContaUsuario();

                contaUsuario.setCpf(rs.getString("cpf"));
                contaUsuario.setSenha(rs.getString("senha"));
                TipoConta tc = TipoConta.valueOf(rs.getString("tipoConta"));
                contaUsuario.setTipoConta(tc);

                usuarios.add(contaUsuario);
            }
            return usuarios;

        } catch (Exception e) {
            throw new SQLException();
        } finally {
            statement.close();
            conexao.desconectar(conn);
        }
    }
        
    public ContaUsuario validarLogin(ContaUsuario contaUsuario) {
        String sql = "SELECT * FROM CONTA_USUARIO cu WHERE cu.cpf = ? AND cu.senha = ?";

        ResultSet rs;
        ContaUsuario retorno = null;
        try {
        conn = conexao.conectar();
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, contaUsuario.getCpf());
        statement.setString(2, contaUsuario.getSenha());
        
        rs = statement.executeQuery();
        
        if(rs.next()){
            retorno = new ContaUsuario();
            retorno.setCpf(rs.getString("cpf"));
            retorno.setSenha(rs.getString("senha"));
            TipoConta tc = TipoConta.valueOf(rs.getString("tipoConta"));
            retorno.setTipoConta(tc);
        }

        } catch (SQLException ex) {
            Logger.getLogger(ContaUsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}