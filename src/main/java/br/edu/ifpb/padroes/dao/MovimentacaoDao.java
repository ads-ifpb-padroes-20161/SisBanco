package br.edu.ifpb.padroes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.edu.ifpb.padroes.conexao.Conexao;
import br.edu.ifpb.padroes.enums.Movimentacao;
import br.edu.ifpb.padroes.interfaces.MovimentacaoDaoIF;
import br.edu.ifpb.padroes.modelo.Administrador;
import br.edu.ifpb.padroes.modelo.Cliente;
import br.edu.ifpb.padroes.modelo.Conta;
import br.edu.ifpb.padroes.modelo.MovimentacaoFinanceira;
import java.sql.Statement;

public class MovimentacaoDao implements MovimentacaoDaoIF {

    private Conexao conexao;
    private Connection conn;

    public MovimentacaoDao() throws SQLException {
        conexao = new Conexao();
    }

    public void salvarMovimentacao(MovimentacaoFinanceira movimentacao) throws SQLException {
        String sql = "INSERT INTO MOVIMENTACAO (codigo, numConta, cpf_cnpj, cpfAdmin, valor, dataHora, tipo) VALUES (?,?, ?, ?, ?, ?, ?)";
        java.util.Date dataUtil = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        try {
            conn = conexao.conectar();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, obterUltimoNum());

            statement.setString(2, movimentacao.getConta().getNumero());
            statement.setString(3, movimentacao.getCliente().getCpf_cnpj());

            if (movimentacao.getAdmin().getCpf() == null) {
                statement.setString(4, null);
            } else {
                statement.setString(4, movimentacao.getAdmin().getCpf());
            }
            statement.setFloat(5, movimentacao.getValor());
            statement.setDate(6, dataSql);
            statement.setString(7, movimentacao.getTipoMovimentacao().toString());

            statement.execute();
            statement.close();

        } catch (Exception e) {
            throw new SQLException(e);

        } finally {
            conexao.desconectar(conn);
        }
    }

    public List<MovimentacaoFinanceira> extrato(Conta conta, Date dataInicio, Date dataFim) throws SQLException {
        /* String sql = "SELECT ct.numero, cl.cpf_cnpj, a.cpf, m.valor, m.dataHora, m.tipo"
         + " FROM  CONTA ct, CLIENTE cl, ADMINISTRADOR a, MOVIMENTACAO m"
         + " WHERE m.numConta = '" + conta.getNumero() + "' AND dataHora BETWEEN ? AND ?";*/
        String sql = "SELECT  * from movimentacao"
                    + " WHERE numconta = '" + conta.getNumero()+ "' AND dataHora BETWEEN ? AND ?";

        ResultSet rs;
        java.sql.Date dataSqlInicio = new java.sql.Date(dataInicio.getTime());
        java.sql.Date dataSqlfim = new java.sql.Date(dataFim.getTime());
        List<MovimentacaoFinanceira> movimentacoes = new ArrayList<MovimentacaoFinanceira>();

        try {
            conn = conexao.conectar();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDate(1, dataSqlInicio);
            statement.setDate(2, dataSqlfim);

            rs = statement.executeQuery();

            Cliente cliente = new Cliente();
            Administrador admin = new Administrador();

            while (rs.next()) {
                MovimentacaoFinanceira movimentacao = new MovimentacaoFinanceira();
                movimentacao.setConta(conta);
                movimentacao.setCliente(cliente);
                movimentacao.setAdmin(admin);
                movimentacao.setValor(rs.getFloat("valor"));
                java.util.Date date = rs.getDate("dataHora");
                movimentacao.setData(date);
                String tipo = rs.getString("tipo");
                Movimentacao movimentacao1 = Enum.valueOf(Movimentacao.class, tipo);
                movimentacao.setTipoMovimentacao(movimentacao1);

                cliente.setCpf_cnpj(rs.getString("cpf_cnpj"));
                admin.setCpf(rs.getString("cpfadmin"));

                movimentacoes.add(movimentacao);
            }
            return movimentacoes;

        } catch (Exception e) {
            throw new SQLException(e);

        } finally {
            conexao.desconectar(conn);
        }
    }

    public int obterUltimoNum() throws SQLException {
        String sql = "SELECT MAX(codigo) maior FROM MOVIMENTACAO";

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

    public float somar(String tipo) throws SQLException {
        String sql = "SELECT SUM(valor) FROM MOVIMENTACAO WHERE tipo='" + tipo + "'";

        ResultSet rs = null;
        Statement statement = null;
        conn = conexao.conectar();
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            if (rs.next()) {
                float soma = rs.getInt("sum");
                return soma;
            }
            return 0;
        } finally {
            rs.close();
            statement.close();
            conexao.desconectar(conn);
        }
    }
}
