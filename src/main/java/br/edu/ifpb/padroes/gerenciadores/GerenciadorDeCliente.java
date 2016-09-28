package br.edu.ifpb.padroes.gerenciadores;

import java.sql.SQLException;

import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.ClienteDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Cliente;
import java.text.ParseException;

public class GerenciadorDeCliente {

    private DaoFactoryIF fabrica = null;
    private ClienteDaoIF clienteDao = null;

    public GerenciadorDeCliente() throws SQLException {
        fabrica = DaoFactory.createFactory();
        clienteDao = fabrica.criarClienteDao();
    }

    public void adicionarCliente(Cliente cliente) throws SQLException, ParseException {

        clienteDao.adicionarCliente(cliente);

    }

    public String pesquisarCliente(String cpf_cnpj) throws SQLException {
        Cliente c = clienteDao.buscarCliente(cpf_cnpj);
        return c.toString();
    }

    public void deletarCliente(String cpf_cnpj) throws SQLException {
        clienteDao.removerCliente(cpf_cnpj);
    }

    public void alterarCliente(Cliente cliente) throws SQLException, ParseException {

        clienteDao.atualizarCliente(cliente);
    }
}
