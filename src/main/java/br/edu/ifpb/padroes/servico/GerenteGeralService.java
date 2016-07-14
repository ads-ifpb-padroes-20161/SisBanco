package br.edu.ifpb.padroes.servico;

import java.sql.SQLException;
import java.text.ParseException;

import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.interfaces.GerenteGeralDaoIF;
import br.edu.ifpb.padroes.modelo.GerenteGeral;

public class GerenteGeralService {
	private DaoFactoryIF fabrica = null;
	private GerenteGeralDaoIF gerenteGeralDao = null;
	
	public GerenteGeralService() throws SQLException{
		fabrica = DaoFactory.createFactory();
		gerenteGeralDao = fabrica.criaGerenteGeralDao();
	}
	
	public void adicionarGerenteGeral(String cpf,String rg,String nome,String dataNasc,String telefone,String email,
			String rua,int numCasa,String bairro,String cidade,String senha) throws SQLException, ParseException{
		
		GerenteGeral novoGerente = new GerenteGeral();
		
		novoGerente.setCpf(cpf);
		novoGerente.setRg(rg);
		novoGerente.setNome(nome);
		novoGerente.setDataNasc(dataNasc);
		novoGerente.setTelefone(telefone);
		novoGerente.setEmail(email);
		novoGerente.setRua(rua);
		novoGerente.setNumCasa(numCasa);;
		novoGerente.setBairro(bairro);
		novoGerente.setCidade(cidade);
		novoGerente.setSenha(senha);
		
		gerenteGeralDao.addGerenteGeral(novoGerente);
		
	}
	
	public GerenteGeral pesquisarGerenteGeral(String cpf) throws SQLException{
		GerenteGeral gerente = gerenteGeralDao.buscaGerenteGeral(cpf); 
		return gerente;
	}
	
	public void deletarGerenteGeral(String cpf) throws SQLException{
		gerenteGeralDao.removeGerenteGeral(cpf);
	}
	
	public void alterarGerenteGeral(String nome,String dataNasc,String telefone,String email,String rua,
			int numCasa,String bairro,String cidade) throws SQLException, ParseException{
		
		GerenteGeral temp = new GerenteGeral();
		temp.setNome(nome);
		temp.setDataNasc(dataNasc);
		temp.setTelefone(telefone);
		temp.setEmail(email);
		temp.setRua(rua);
		temp.setNumCasa(numCasa);
		temp.setBairro(bairro);
		temp.setCidade(cidade);
		
		gerenteGeralDao.atualizarGerenteGeral(temp);
	}
}