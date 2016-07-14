package br.edu.ifpb.padroes.interfaces;

import br.edu.ifpb.padroes.modelo.ContaUsuario;
import java.sql.SQLException;
import java.util.List;

public interface ContaUsuarioDaoIF {

    public void addContaUsuario(ContaUsuario contaUsuario) throws SQLException, Exception;

    public void removerContaUsuario(String cpf) throws SQLException;

    public void atualizarContaUsuario(ContaUsuario contaUsuario) throws SQLException, Exception;

    public ContaUsuario buscarContaUsuario(String cpf) throws SQLException;
    
    public List<ContaUsuario> buscarTodas() throws SQLException;
    
    public ContaUsuario validarLogin(ContaUsuario contaUsuario);

}
