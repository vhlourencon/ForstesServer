package br.com.fortes.server;

import java.util.ArrayList;
import java.util.List;

import br.com.fortes.server.exception.GenericException;
import br.com.fortes.server.model.FilmeModel;
import br.com.fortes.server.negocio.FilmeNegocio;

public class TesteHibernate {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FilmeNegocio filmeNegocio = new FilmeNegocio();
		
		
		ArrayList<FilmeModel> lista  =(ArrayList<FilmeModel>) filmeNegocio.obterTodos(FilmeModel.class);
	//	lista.get(0).setAlugado(true);
		for (FilmeModel filmeModel : lista) {
			System.out.println(filmeModel.getNome());
		//	System.out.println(filmeModel.isAlugado());
		}
		filmeNegocio.excluir(lista.get(lista.size() -1));
		
       
	}

}
