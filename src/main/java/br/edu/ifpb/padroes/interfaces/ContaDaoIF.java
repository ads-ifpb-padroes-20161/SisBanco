package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import br.edu.ifpb.padroes.modelo.Conta;

public interface ContaDaoIF {

    public int obterNumConta() throws SQLException;

    public void salvarConta(Conta conta) throws SQLException;

    public void removeConta(int numero) throws SQLException;

    public Conta buscaConta(int numero) throws SQLException;

    public void atualizarSaldo(Conta conta, float valor) throws SQLException;

    public float consultarSaldo(Conta conta) throws SQLException;
}
