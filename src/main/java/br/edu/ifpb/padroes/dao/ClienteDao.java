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
import br.edu.ifpb.padroes.interfaces.ClienteDaoIF;
import br.edu.ifpb.padroes.modelo.Cliente;
import br.edu.ifpb.padroes.modelo.Conta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDao implements ClienteDaoIF {

    Conexao conexao;
    Connection conn;

    public ClienteDao() throws SQLException {
        conexao = new Conexao();
    }

    public void addCliente(Cliente cliente) throws SQLException, ParseException {
        String sql = "INSERT INTO CLIENTE (cpf_cnpj, rg, nome, dataNasc, telefone, email, rua, numCasa"
                + ", bairro, cidade, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?);";

        String sql2 = "INSERT INTO CONTA_CLIENTE (cpf_cnpj, numConta) VALUES (?, ?);";

        String dataString = cliente.getDataNasc();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(formato.parse(dataString).getTime());

        try {
            conn = conexao.conectar();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getCpf_cnpj());
            statement.setString(2, cliente.getRg());
            statement.setString(3, cliente.getNome());
            statement.setDate(4, data);
            statement.setString(5, cliente.getTelefone());
            statement.setString(6, cliente.getEmail());
            statement.setString(7, cliente.getRua());
            statement.setInt(8, cliente.getNumCasa());
            statement.setString(9, cliente.getBairro());
            statement.setString(10, cliente.getCidade());
            statement.setString(11, cliente.getSenha());

            statement.execute();

            statement = conn.prepareStatement(sql2);
            statement.setString(1, cliente.getCpf_cnpj());
            statement.setInt(2, cliente.getContas().get(0).getNumero());
            statement.execute();
            statement.close();

        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }

    public void removeCliente(String cpf_cnpj) throws SQLException {
        String sql = "DELETE FROM CLIENTE WHERE cpf_cnpj = '" + cpf_cnpj + "';";
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

    public void atualizarCliente(Cliente cliente) throws SQLException, ParseException {
        String dataString = cliente.getDataNasc();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(formato.parse(dataString).getTime());

        String sql = "UPDATE CLIENTE SET nome = '" + cliente.getNome() + "', dataNasc = '"
                + data + "', telefone = '" + cliente.getTelefone() + "', email = '"
                + cliente.getEmail() + "', rua = '" + cliente.getRua() + "', numCasa = '" + cliente.getNumCasa()
                + "', bairro = '" + cliente.getBairro() + "', cidade = '" + cliente.getCidade() + "';";
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

    public Cliente buscaCliente(String cpf_cnpj) throws SQLException {
        String sql = "SELECT * FROM CLIENTE WHERE cpf_cnpj = '" + cpf_cnpj + "';";
        ResultSet rs;
        try {
            conn = conexao.conectar();
            Statement statement = conn.createStatement();

            rs = statement.executeQuery(sql);
            Cliente cliente = new Cliente();

            while (rs.next()) {
                cliente.setCpf_cnpj(rs.getString("cpf_cnpj"));
                cliente.setRg(rs.getString("rg"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNasc(rs.getString("dataNasc"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumCasa(rs.getInt("numCasa"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setContas(listarContasCliente(cliente.getCpf_cnpj()));
            }
            return cliente;
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            conexao.desconectar(conn);
        }
    }
    
    public List<Conta> listarContasCliente(String cpf) throws SQLException{
        String sql = "select * from conta c where c.numero in "
                + "(select cc.numconta from conta_cliente cc where cc.cpf_cnpj = ?)";
        
        ResultSet rs;
        List<Conta> contas = new ArrayList();
        try {
            conn = conexao.conectar();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, cpf);
            
            rs = statement.executeQuery();
            
            Conta conta;
            
            while(rs.next()){
                conta = new Conta();
                conta.setNumero(rs.getInt("numero"));
                conta.setSaldo(rs.getFloat("saldo"));
                
                contas.add(conta);
            }
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            conexao.desconectar(conn);
        }
        return contas;
    }
}
