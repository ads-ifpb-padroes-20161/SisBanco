package br.edu.ifpb.padroes.interfaces;

import java.sql.SQLException;
import br.edu.ifpb.padroes.modelo.Agencia;
import java.util.List;

public interface AgenciaDaoIF{
	public void addAgencia(Agencia ag) throws SQLException;
	public void removerAgencia(int numAgencia) throws SQLException;
	public void atualizarAgencia(Agencia ag)throws SQLException;
	public Agencia buscarAgencia(int numAgencia) throws SQLException;
        public List<Agencia> buscarTodas() throws SQLException;
}