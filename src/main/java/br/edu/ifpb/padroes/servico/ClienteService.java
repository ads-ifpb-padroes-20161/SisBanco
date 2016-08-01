package br.edu.ifpb.padroes.servico;

import java.sql.SQLException;
import java.text.ParseException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.ClienteDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Cliente;
import br.edu.ifpb.padroes.modelo.Conta;
import java.util.List;

public class ClienteService {
	
	private DaoFactoryIF fabrica = null;
	private ClienteDaoIF clienteDao = null;
	
	public ClienteService() throws SQLException{
		fabrica = DaoFactory.createFactory();
		clienteDao = fabrica.criarClienteDao();
	}
	
	public void adicionarCliente(Cliente cliente) throws SQLException, ParseException{
		clienteDao.adicionarCliente(cliente);
	}
	
	public Cliente pesquisarCliente(String cpf_cnpj) throws SQLException{
		Cliente cliente = clienteDao.buscarCliente(cpf_cnpj); 
		return cliente;
	}
        
        public List<Conta> listarContasCliente(String cpf) throws SQLException{
            return clienteDao.listarContasCliente(cpf);
        }
	
	public void deletarCliente(String cpf_cnpj) throws SQLException{
		clienteDao.removerCliente(cpf_cnpj);
	}
	
	public void alterarCliente(Cliente cliente) throws SQLException, ParseException{
		clienteDao.atualizarCliente(cliente);
	}
}