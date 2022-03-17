package br.com.fortes.server.negocio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.com.fortes.server.dao.FilmeDAO;
import br.com.fortes.server.exception.GenericException;
import br.com.fortes.server.model.FilmeModel;

@Service
public class FilmeNegocio extends GenericNegocio<FilmeModel, FilmeDAO, GenericException> {

	public FilmeNegocio() {
		super();
		dao = new FilmeDAO();
	}

	@Override
	public GenericException validar(FilmeModel vo) {
		StringBuffer msg = new StringBuffer("");
		if (vo.getNome() == null || vo.getNome().trim().length() == 0) {
			msg.append("O campo Nome  é de preenchimento obrigatório! \n");
		}

		if (msg.length() > 0)
			return new GenericException(msg.toString());
		else
			return null;
	}

	@Override
	public String getSqlFiltro(FilmeModel vo) {
		String filtro = "FROM " + vo.getClass().getCanonicalName() + " g ";
		filtro += " where 1=1 ";

		if (vo.getNome() != null && vo.getNome().trim().length() > 0) {
			filtro += " and nome like('%" + vo.getNome() + "%')";
		}

		filtro += " order by id asc";

		return filtro;
	}

}
