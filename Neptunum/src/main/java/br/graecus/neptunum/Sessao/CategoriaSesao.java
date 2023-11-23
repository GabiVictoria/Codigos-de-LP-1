package br.graecus.neptunum.Sessao;

import br.graecus.neptunum.modelos.*;
import br.graecus.neptunum.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoriaSesao {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarCategoria(Categoria categoria){
        Transaction transaction = session.beginTransaction();
        session.persist(categoria);
        transaction.commit();
    }
    public List<Categoria> listaCategoria(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Categoria> query = session.createQuery("from Categoria ", Categoria.class);
        return query.getResultList();
    }
}
