package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import br.edu.ifpb.padroes.modelo.Agencia;
import java.util.List;

public interface AgenciaDaoIF {

    public void adicionarAgencia(Agencia agencia) throws SQLException;

    public void removerAgencia(String numAgencia) throws SQLException;

    public void atualizarAgencia(Agencia agencia) throws SQLException;

    public Agencia buscarAgencia(String numAgencia) throws SQLException;

    public List<Agencia> buscarTodas() throws SQLException;
}
