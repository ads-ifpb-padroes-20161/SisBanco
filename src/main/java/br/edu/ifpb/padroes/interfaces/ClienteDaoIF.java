package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import java.text.ParseException;

import br.edu.ifpb.padroes.modelo.Cliente;
import br.edu.ifpb.padroes.modelo.Conta;
import java.util.List;

public interface ClienteDaoIF {
	public void addCliente(Cliente cliente) throws SQLException, ParseException;
	public void removeCliente(String cpf_cnpj) throws SQLException;
	public void atualizarCliente(Cliente cliente)throws SQLException, ParseException;
	public Cliente buscaCliente(String cpf_cnpj) throws SQLException;
        public List<Conta> listarContasCliente(String cpf) throws SQLException;
}