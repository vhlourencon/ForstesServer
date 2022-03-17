package br.com.fortes.server.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.fortes.server.ConnectFactory;
import br.com.fortes.server.dao.GenericDAO;
import br.com.fortes.server.model.GenericModel;

public abstract class GenericNegocio<GENERICMODEL extends GenericModel, DAOG extends GenericDAO<GENERICMODEL>, EXCEPTION extends Exception> {

	protected DAOG dao;

	public GENERICMODEL salvar(GENERICMODEL vo) throws Exception {

		EXCEPTION exc = validar(vo);
		if (exc == null) {
			Session session = ConnectFactory.getSession();
			try {
				session.beginTransaction();
				GENERICMODEL model = dao.salvar(vo);
				session.getTransaction().commit();
				return model;
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				e.printStackTrace();
				throw (EXCEPTION) new Exception("Ocorreu um erro ao tentar salvar:\n" + e.getMessage());
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		} else {
			throw exc;
		}
	}

	public GENERICMODEL merge(GENERICMODEL vo) throws EXCEPTION {
		EXCEPTION exc = validar(vo);
		if (exc == null) {
			try {
				dao.merge(vo);
				return vo;
			} catch (Exception e) {
				throw (EXCEPTION) new Exception("Ocorreu um erro ao tentar salvar:\n" + e.getMessage());
			}
		} else {
			throw exc;
		}
	}

	public void alterar(GENERICMODEL model) throws EXCEPTION {
		EXCEPTION exc = validar(model);
		if (exc == null) {

			Session session = ConnectFactory.getSession();
			try {
				session.beginTransaction();
				dao.alterar(model);
				session.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				e.printStackTrace();
				throw (EXCEPTION) new Exception("Ocorreu um erro ao tentar alterar:\n" + e.getMessage());
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}

		} else {
			throw exc;
		}
	}

	public void excluir(GENERICMODEL model) throws EXCEPTION {
		Session session = ConnectFactory.getSession();
		try {
			session.beginTransaction();
			dao.excluir(model);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw (EXCEPTION) new Exception("Ocorreu um erro ao tentar excluir:\n" + e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	public GENERICMODEL obterPorId(GENERICMODEL model) throws EXCEPTION {

		if (model.getId() != null) {
			try {
				model = dao.obterPorId(model);
				return model;
			} catch (Exception e) {
				throw (EXCEPTION) new Exception("Ocorreu um erro ao executar a operação:\n" + e.getMessage());
			}

		} else {
			throw ((EXCEPTION) new Exception("O id não pode ser nulo"));
		}

	}

	public GENERICMODEL obterPorId(Class classe, Long id) throws Exception {

		Session session = ConnectFactory.getSession();
		try {
			session.beginTransaction();
			GENERICMODEL model = dao.obterPorId(classe, id);
			session.getTransaction().commit();
			return model;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();

			}
		}
	}

	public List<GENERICMODEL> obterTodos(Class classe) throws Exception {

		Session session = ConnectFactory.getSession();
		try {
			session.beginTransaction();
			List<GENERICMODEL> lista = (List<GENERICMODEL>) dao.obterTodos(classe);
			session.getTransaction().commit();
			return lista;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public abstract EXCEPTION validar(GENERICMODEL vo);

	public String getGenericFiltro(GENERICMODEL vo) {
		String filtroGenerico = "FROM " + vo.getClass().getCanonicalName() + " g ";
		return filtroGenerico;
	}

	public String getSqlFiltro(GENERICMODEL vo) {
		String filtro = getGenericFiltro(vo);
		return filtro;
	}
}