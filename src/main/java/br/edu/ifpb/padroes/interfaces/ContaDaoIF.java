package br.edu.ifpb.padroes.interfaces;

import br.edu.ifpb.padroes.modelo.Cliente;
import java.sql.SQLException;
import br.edu.ifpb.padroes.modelo.Conta;
import java.util.List;

public interface ContaDaoIF {

    public int obterNumConta() throws SQLException;

    public void adicionarConta(Conta conta) throws SQLException;

    public void removerConta(String numero) throws SQLException;

    public Conta buscarConta(String numero) throws SQLException;

    public List<Conta> buscarTodas() throws SQLException;

    public List<Conta> buscarPorAgencia(String numAgencia) throws SQLException;

    public void atualizarSaldo(Conta conta, float valor) throws SQLException;

    public float consultarSaldo(Conta conta) throws SQLException;

    public List<Cliente> buscarTitulares(String numConta) throws SQLException;
}
