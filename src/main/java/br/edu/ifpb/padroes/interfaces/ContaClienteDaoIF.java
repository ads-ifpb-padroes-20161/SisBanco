package br.edu.ifpb.padroes.interfaces;

import br.edu.ifpb.padroes.modelo.ContaCliente;
import java.sql.SQLException;

public interface ContaClienteDaoIF {

    public void adicionarContaCliente(ContaCliente contaCliente) throws SQLException, Exception;

    public void removerContaCliente(String cpf) throws SQLException;

}
