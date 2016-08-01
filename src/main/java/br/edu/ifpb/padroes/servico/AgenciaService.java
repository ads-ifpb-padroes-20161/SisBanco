package br.edu.ifpb.padroes.servico;

import java.sql.SQLException;
import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.AgenciaDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.Agencia;
import br.edu.ifpb.padroes.modelo.GerenteGeral;
import java.util.List;

public class AgenciaService {
	
	private DaoFactoryIF fabrica = null;
	private AgenciaDaoIF agenciaDao = null;
	
	public AgenciaService() throws SQLException{
		fabrica = DaoFactory.createFactory();
		agenciaDao = fabrica.criarAgenciaDao();
	}
	
	public void adicionarAgencia(int numero,String nome,String telefone,String rua,int numSede,String bairro,String cidade,
			GerenteGeral gerenteG) throws SQLException{
		
		Agencia agencia = new Agencia();
		agencia.setNumero(numero);
		agencia.setNome(nome);
		agencia.setTelefone(telefone);
		agencia.setRua(rua);
		agencia.setNumSede(numSede);
		agencia.setBairro(bairro);
		agencia.setCidade(cidade);
		
		agenciaDao.adicionarAgencia(agencia);
	}
	
	public Agencia pesquisarAgencia(int numero) throws SQLException{
		Agencia ag = agenciaDao.buscarAgencia(numero); 
		return ag;
	}
	
	public void deletarAgencia(int numero) throws SQLException{
		agenciaDao.removerAgencia(numero);
	}
	
	public void alterarAgencia(int numero,String nome,String telefone,String rua,int numSede,String bairro,String cidade,
			GerenteGeral gerenteG) throws SQLException{
		
		Agencia temp = new Agencia();
		temp.setNome(nome);
		temp.setTelefone(telefone);
		temp.setRua(rua);
		temp.setNumSede(numSede);
		temp.setBairro(bairro);
		temp.setCidade(cidade);
		
		agenciaDao.atualizarAgencia(temp);
	}
        
        public List<Agencia> listaAgencia() throws SQLException{
            return agenciaDao.buscarTodas();
        }
}