package br.com.fortes.server;

import java.util.List;

import br.com.fortes.server.exception.GenericException;
import br.com.fortes.server.model.FilmeModel;
import br.com.fortes.server.negocio.FilmeNegocio;

public class TesteHibernate {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FilmeNegocio filmeNegocio = new FilmeNegocio();
		
		FilmeModel filmeModel  = 	filmeNegocio.obterPorId(FilmeModel.class,1l);
		System.out.println(filmeModel.getNome());
       
	}

}
