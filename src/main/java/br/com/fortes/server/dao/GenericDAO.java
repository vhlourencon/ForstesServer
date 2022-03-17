package br.com.fortes.server.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.fortes.server.ConnectFactory;
import br.com.fortes.server.model.GenericModel;


public abstract class GenericDAO<GENERICMODEL extends GenericModel>
    {

        public GENERICMODEL salvar(GENERICMODEL vo) throws SQLException {
           
        	 Session session = ConnectFactory.getSession();
             session.save(vo);
             return vo;
        }

        public void alterar(GENERICMODEL model) throws SQLException {
            Session session = ConnectFactory.getSession();
            session.merge(model);

        }

        public void excluir(GENERICMODEL model) throws SQLException {
        	 Session session = ConnectFactory.getSession();
        	 session.remove(model);
        }

     

        public GENERICMODEL merge(GENERICMODEL vo) throws SQLException {
            Session session = ConnectFactory.getSession();
            session.merge(vo);

            return vo;
        }

        public GENERICMODEL obterPorId(GENERICMODEL model) throws SQLException {
            Session session = ConnectFactory.getSession();
            Query select = session.createQuery("select g FROM " + model.getClass().getCanonicalName() + " g WHERE g.id = :id ");
            select.setParameter("id", model.getId());
            model = (GENERICMODEL) select.getSingleResult();
            return (GENERICMODEL) model;
        }

        public GENERICMODEL obterPorId(Class classe, Long id) throws SQLException {
            Session session = ConnectFactory.getSession();
            
            Query select = session.createQuery("select g FROM " + classe.getCanonicalName() + " g WHERE g.id = :id ");
            select.setParameter("id", id);
            
            GENERICMODEL model =  (GENERICMODEL) select.getSingleResult();
            return model;
        }

      
        public ArrayList<GENERICMODEL> obterTodos(Class c) throws SQLException {
            Session session = ConnectFactory.getSession();
            Query select = session.createQuery(" FROM " + c.getCanonicalName() + " g");
     
            ArrayList<GENERICMODEL> lista = (ArrayList<GENERICMODEL>) select.getResultList();
            return lista;
            
          
        }

       
       

    }
