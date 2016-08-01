package br.edu.ifpb.padroes.servico;

import br.edu.ifpb.padroes.dao.DaoFactory;
import br.edu.ifpb.padroes.interfaces.ContaUsuarioDaoIF;
import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;
import br.edu.ifpb.padroes.modelo.ContaUsuario;
import java.sql.SQLException;
import java.text.ParseException;

public class ContaUsuarioService {

    private DaoFactoryIF fabrica = null;
    private ContaUsuarioDaoIF contaUsuarioDao = null;

    public ContaUsuarioService() throws SQLException {
        fabrica = DaoFactory.createFactory();
        contaUsuarioDao = fabrica.criarContaUsuarioDao();
    }

    public void adicionarContaUsuario(ContaUsuario contaUsuario) throws SQLException, ParseException, Exception {
        contaUsuarioDao.adicionarContaUsuario(contaUsuario);
    }

    public ContaUsuario pesquisarContaUsuario(String cpf) throws SQLException {
        ContaUsuario contaUsuario = contaUsuarioDao.buscarContaUsuario(cpf);
        return contaUsuario;
    }

    public void deletarContaUsuario(String cpf) throws SQLException {
        contaUsuarioDao.removerContaUsuario(cpf);
    }

    public void atualizarContaUsuario(ContaUsuario contaUsuario) throws SQLException, ParseException, Exception {
        contaUsuarioDao.atualizarContaUsuario(contaUsuario);
    }

    public ContaUsuario validarLogin(ContaUsuario contaUsuario){
        return contaUsuarioDao.validarLogin(contaUsuario);       
    }
}