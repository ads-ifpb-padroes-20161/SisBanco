package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import br.edu.ifpb.padroes.modelo.Cliente;
import br.edu.ifpb.padroes.modelo.Conta;
import java.util.List;

public interface ClienteDaoIF {

    public void adicionarCliente(Cliente cliente) throws SQLException, ParseException;

    public void removerCliente(String cpf_cnpj) throws SQLException;

    public void atualizarCliente(Cliente cliente) throws SQLException, ParseException;

    public Cliente buscarCliente(String cpf_cnpj) throws SQLException;

    public List<Cliente> buscarTodos() throws SQLException;

    public List<Conta> listarContasCliente(String cpf) throws SQLException;
}
