package br.edu.ifpb.padroes.servico;

import java.sql.SQLException;
import java.text.ParseException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.interfaces.GerenteDaoIF;
import br.edu.ifpb.padroes.modelo.Agencia;
import br.edu.ifpb.padroes.modelo.Gerente;

public class GerenteService {
	
	private DaoFactoryIF fabrica = null;
	private GerenteDaoIF gerenteDao = null;
	
	public GerenteService() throws SQLException{
		fabrica = DaoFactory.createFactory();
		gerenteDao = fabrica.criarGerenteDao();
	}
	
	public void adicionarGerente(String cpf,String rg,String nome,String dataNasc,String telefone,String email,
			String rua,int numCasa,String bairro,String cidade,String senha,Agencia agencia) throws SQLException, ParseException{
		
		Gerente novoGerente = new Gerente();
		
		novoGerente.setCpf(cpf);
		novoGerente.setRg(rg);
		novoGerente.setNome(nome);
		novoGerente.setDataNasc(dataNasc);
		novoGerente.setTelefone(telefone);
		novoGerente.setEmail(email);
		novoGerente.setRua(rua);
		novoGerente.setNumCasa(numCasa);
		novoGerente.setBairro(bairro);
		novoGerente.setCidade(cidade);
		novoGerente.setSenha(senha);
		novoGerente.setAgencia(agencia);
		
		gerenteDao.adicionarGerente(novoGerente);
		
	}
	
	public Gerente pesquisarGerente(String cpf) throws SQLException{
		Gerente gerente = gerenteDao.buscarGerente(cpf); 
		return gerente;
	}
	
	public void deletarGerente(String cpf) throws SQLException{
		gerenteDao.removerGerente(cpf);
	}
	
	public void alterarGerente(String nome,String dataNasc,String telefone,String email,String rua,
			int numCasa,String bairro,String cidade,Agencia agencia) throws SQLException, ParseException{
		
		Gerente temp = new Gerente();
		temp.setNome(nome);
		temp.setDataNasc(dataNasc);
		temp.setTelefone(telefone);
		temp.setEmail(email);
		temp.setRua(rua);
		temp.setNumCasa(numCasa);
		temp.setBairro(bairro);
		temp.setCidade(cidade);
		
		gerenteDao.atualizarGerente(temp);
	}
}