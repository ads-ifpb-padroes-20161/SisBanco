package br.edu.ifpb.padroes.servico;

import java.sql.SQLException;

import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.AdministradorDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Administrador;

public class AdministradorService {
	
	private DaoFactoryIF fabrica = null;
	private AdministradorDaoIF administradorDao = null;
	
	public AdministradorService() throws SQLException{
		fabrica = DaoFactory.createFactory();
		administradorDao = fabrica.criaAdministradorDao();
	}
	
	public void adicionarAdministrador(String cpf,String rg,String nome,String dataNasc,String telefone,String email,
			String rua,int numCasa,String bairro,String cidade,String senha) throws Exception{
		
		Administrador novoAdmin = new Administrador();
		
		novoAdmin.setCpf(cpf);
		novoAdmin.setRg(rg);
		novoAdmin.setNome(nome);
		novoAdmin.setDataNasc(dataNasc);
		novoAdmin.setTelefone(telefone);
		novoAdmin.setEmail(email);
		novoAdmin.setRua(rua);
		novoAdmin.setNumCasa(numCasa);;
		novoAdmin.setBairro(bairro);
		novoAdmin.setCidade(cidade);
		novoAdmin.setSenha(senha);
		
		administradorDao.addAdministrador(novoAdmin);;
		
	}
	
	public Administrador pesquisarAdministrador(String cpf) throws SQLException{
		Administrador admin = administradorDao.buscaAdministrador(cpf); 
		return admin;
	}
	
	public void deletarAdministrador(String cpf) throws SQLException{
		administradorDao.removeAdministrador(cpf);
	}
	
	public void alterarAdministrador(String nome,String dataNasc,String telefone,String email,String rua,
			int numCasa,String bairro,String cidade) throws Exception{
		
		Administrador temp = new Administrador();
		temp.setNome(nome);
		temp.setDataNasc(dataNasc);
		temp.setTelefone(telefone);
		temp.setEmail(email);
		temp.setRua(rua);
		temp.setNumCasa(numCasa);
		temp.setBairro(bairro);
		temp.setCidade(cidade);
		
		administradorDao.atualizarAdministrador(temp);
	}
}