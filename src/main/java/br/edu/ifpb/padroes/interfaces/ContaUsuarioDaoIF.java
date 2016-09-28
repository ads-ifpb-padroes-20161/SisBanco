package br.edu.ifpb.padroes.interfaces;

import br.edu.ifpb.padroes.modelo.ContaUsuario;
import java.sql.SQLException;

public interface ContaUsuarioDaoIF {

    public void adicionarContaUsuario(ContaUsuario contaUsuario) throws SQLException, Exception;

    public void removerContaUsuario(String cpf) throws SQLException;

    public ContaUsuario buscarContaUsuario(String cpf) throws SQLException;

    public ContaUsuario validarLogin(ContaUsuario contaUsuario);
}
