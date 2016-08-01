package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import br.edu.ifpb.padroes.modelo.Conta;
import java.util.List;

public interface ContaDaoIF {

    public int obterNumConta() throws SQLException;

    public void adicionarConta(Conta conta) throws SQLException;

    public void removerConta(int numero) throws SQLException;

    public Conta buscarConta(int numero) throws SQLException;
    
    public List<Conta> buscarTodas() throws SQLException;

    public void atualizarSaldo(Conta conta, float valor) throws SQLException;

    public float consultarSaldo(Conta conta) throws SQLException;
}