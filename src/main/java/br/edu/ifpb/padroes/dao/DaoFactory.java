package br.edu.ifpb.padroes.dao;

import br.edu.ifpb.padroes.interfaces.DaoFactoryIF;

public class DaoFactory {
	
	public static DaoFactoryIF createFactory(){
		return new DaoFactoryBD();
	}
}